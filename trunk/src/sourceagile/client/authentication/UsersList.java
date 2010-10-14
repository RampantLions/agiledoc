package sourceagile.client.authentication;

import sourceagile.shared.User;
import sourceagile.shared.data.UserData;

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
