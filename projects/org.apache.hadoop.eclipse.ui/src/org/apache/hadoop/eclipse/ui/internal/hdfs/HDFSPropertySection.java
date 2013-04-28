package org.apache.hadoop.eclipse.ui.internal.hdfs;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileSystem;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetSorter;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class HDFSPropertySection extends AbstractPropertySection {

	private static final Logger logger = Logger.getLogger(HDFSPropertySection.class);

	private static class HDFSPropertySheetPage extends PropertySheetPage {
		public HDFSPropertySheetPage() {
			final List<String> namesList = new ArrayList<String>();
			namesList.add("User");
			namesList.add("Group");
			namesList.add("Is downloaded");
			namesList.add("Effective Permissions");
			namesList.add("User Permissions");
			namesList.add("Group Permissions");
			namesList.add("Other Permissions");
			setSorter(new PropertySheetSorter() {
				@Override
				public int compare(IPropertySheetEntry entryA, IPropertySheetEntry entryB) {
					int indexA = namesList.indexOf(entryA.getCategory());
					int indexB = namesList.indexOf(entryB.getCategory());
					return indexA - indexB;
				}
				@Override
				public int compareCategories(String categoryA, String categoryB) {
					int indexA = namesList.indexOf(categoryA);
					int indexB = namesList.indexOf(categoryB);
					return indexA - indexB;
				}
			});
		}
	}

	private Composite topComposite;
	private Composite nonHDFSComposite;
	private StackLayout stackLayout;
	private Composite hdfsResourceTopComposite;
	private HDFSFileStore store;
	private Composite hdfsResourceComposite;
	private Composite hdfsPropertiesComposite;
	private PropertySheetPage propertySheetPage;

	public HDFSPropertySection() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage page) {
		topComposite = page.getWidgetFactory().createComposite(parent);
		stackLayout = new StackLayout();
		topComposite.setLayout(stackLayout);
		// no HDFS
		nonHDFSComposite = page.getWidgetFactory().createComposite(topComposite);
		nonHDFSComposite.setLayout(new GridLayout());
		page.getWidgetFactory().createLabel(nonHDFSComposite, "Selection is not a HDFS resource").setLayoutData(new GridData());
		// Project
		hdfsResourceTopComposite = page.getWidgetFactory().createComposite(topComposite);
		final GridLayout hdfsResourceLayout = new GridLayout(2, false);
		hdfsResourceLayout.marginLeft = hdfsResourceLayout.marginBottom = hdfsResourceLayout.marginWidth = hdfsResourceLayout.marginHeight = hdfsResourceLayout.marginTop = hdfsResourceLayout.marginRight = 0;
		hdfsResourceTopComposite.setLayout(hdfsResourceLayout);
		hdfsResourceComposite = page.getWidgetFactory().createComposite(hdfsResourceTopComposite);
		GridData gd = new GridData(GridData.FILL_VERTICAL | GridData.GRAB_VERTICAL);
		gd.widthHint = 0; // TODO increase width when graphs available.
		hdfsResourceComposite.setLayoutData(gd);
		hdfsPropertiesComposite = page.getWidgetFactory().createComposite(hdfsResourceTopComposite);
		hdfsPropertiesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		hdfsPropertiesComposite.setLayout(new FillLayout());
		createPropertiesPage(hdfsPropertiesComposite, page);
	}

	/**
	 * @param hdfsPropertiesComposite2
	 * @param page
	 */
	private void createPropertiesPage(Composite parent, final TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		propertySheetPage = new HDFSPropertySheetPage();
		propertySheetPage.createControl(composite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		propertySheetPage.getControl().setLayoutData(data);
		propertySheetPage.getControl().addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				atabbedPropertySheetPage.resizeScrolledComposite();
			}
		});
		propertySheetPage.selectionChanged(getPart(), getSelection());
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		this.store = null;
		Composite c = nonHDFSComposite;
		if (!selection.isEmpty()) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IResource) {
				IResource resource = (IResource) firstElement;
				try {
					if (resource.getLocationURI() != null && HDFSFileSystem.SCHEME.equals(resource.getLocationURI().getScheme())) {
						c = hdfsResourceTopComposite;
						store = (HDFSFileStore) EFS.getStore(resource.getLocationURI());
					}
				} catch (CoreException e) {
					logger.warn(e.getMessage(), e);
				}
			}
		}
		selection = new StructuredSelection(this.store);
		if (this.propertySheetPage != null)
			this.propertySheetPage.selectionChanged(part, selection);
		super.setInput(part, selection);
		stackLayout.topControl = c;
		topComposite.layout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (this.propertySheetPage != null) {
			this.propertySheetPage.dispose();
			this.propertySheetPage = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		if (this.propertySheetPage != null)
			this.propertySheetPage.refresh();
	}
}
