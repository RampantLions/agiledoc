package sourceagile.client.planning;

import sourceagile.client.systemNavigation.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The user can insert a new task in the system typing the name, description and
 * the priority of the task in a web based form page.
 * 
 */
public class NewFeature extends VerticalPanel {

	private static ListBox path = new ListBox();
	private static TextBox name = new TextBox();
	private static TextArea description = new TextArea();

	public NewFeature() {

		Label space = new Label(" ");
		space.setHeight("50");
		this.add(space);

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);

		// if (GlobalVariables.getProject().getFeaturesPacks() == null) {

		// getFeaturesPacks();
		// }

		vp.add(featureFields());

		this.add(vp);
	}

	/*
	 * private void getFeaturesPacks() {
	 * 
	 * ArrayList<Pack> packs = new ArrayList<Pack>();
	 * 
	 * String packName = "";
	 * 
	 * for (Classe feature : GlobalVariables.getProject().getFeatures()) {
	 * 
	 * if (!feature.getPack().getFullName().equals(packName)) {
	 * 
	 * packs.add(feature.getPack());
	 * 
	 * packName = feature.getPack().getFullName(); } }
	 * 
	 * GlobalVariables.getProject().setFeaturesPacks(packs); }
	 */

	/*
	 * public static HorizontalPanel comboPackages() {
	 * 
	 * path.clear(); for (Pack pack :
	 * GlobalVariables.getProject().getFeaturesPacks()) {
	 * 
	 * path.addItem(pack.getName(), pack.getFullName()); }
	 * 
	 * HorizontalPanel hp = new HorizontalPanel();
	 * hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	 * 
	 * Label title = new Label("Package: "); title.setWidth("100");
	 * hp.add(title);
	 * 
	 * path.setWidth("300"); hp.add(path);
	 * 
	 * hp.add(new Label(" "));
	 * 
	 * Button button = new Button("New Package",
	 * 
	 * new ClickHandler() {
	 * 
	 * @Override public void onClick(ClickEvent event) {
	 * 
	 * } }); hp.add(button);
	 * 
	 * return hp; }
	 */

	public static VerticalPanel featureFields() {

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(50);

		HTML title = new HTML("<B>Enter the new feature bellow: </B>");
		vp.add(title);

		// vp.add(comboPackages());

		name.setWidth("300");
		vp.add(new FormField("Name", name));

		description.setSize("500", "40");
		vp.add(new FormField("Description", description));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(saveButton());

		return vp;
	}

	private static Button saveButton() {

		Button button = new Button("Create New Feature",

		new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				/*
				 * Pack pack = new Pack();
				 * pack.setFullName(path.getValue(path.getSelectedIndex()));
				 * 
				 * Classedoc classeDoc = new Classedoc();
				 * classeDoc.setClassName(name.getValue());
				 * classeDoc.setDescription(description.getValue());
				 * 
				 * Classe classe = new Classe(); classe.setPack(pack);
				 * classe.setClasseDoc(classeDoc);
				 * 
				 * classe.setPriority(Integer.parseInt(priority.getValue()));
				 * 
				 * new CreateTodoClass(classe);
				 */
			}
		});

		return button;
	}
}
