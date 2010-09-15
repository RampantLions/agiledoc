package agiledoc.shared.data;

import agiledoc.shared.User;

public class UserData {

	public static User[] load() {

		User[] users = new User[1];

		users[0] = new User();
		users[0].setName("Alline.Oliveira");
		users[0].setPassword("bD8Km8se2rV9");

		return users;
	}
}
