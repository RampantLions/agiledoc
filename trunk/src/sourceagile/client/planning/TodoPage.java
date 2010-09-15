package sourceagile.client.planning;

import sourceagile.shared.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TodoPage extends VerticalPanel {

	public TodoPage(Entry[] entries) {

		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.setSize("97%", "100%");

		VerticalPanel vp1 = new VerticalPanel();
		vp1.setSize("100%", "100%");
		vp1.setSpacing(30);
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp1.add(buttonNewFeature());

		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.add(new TodoList(entries));

		vp.add(vp1);

		this.add(vp);
	}

	public static Button buttonNewFeature() {

		Button button = new Button("New Feature", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new NewFeature();
			}
		});

		return button;
	}
}
