package sourceagile.authentication.client;

import sourceagile.shared.data.UserData;
import sourceagile.shared.entities.User;

import com.google.gwt.user.client.ui.ListBox;

public class UsersList extends ListBox {

	public UsersList() {

		this.setWidth("200px");

		this.addItem("");

		User[] users = UserData.load();

		for (int j = 0; j < users.length; j++) {

			User user = users[j];

			this.addItem(user.getName(), String.valueOf(j));
		}

	}

}