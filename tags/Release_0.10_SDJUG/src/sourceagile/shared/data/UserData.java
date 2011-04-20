package sourceagile.shared.data;

import sourceagile.shared.entities.User;

public class UserData {

	public static User[] load() {

		User[] users = new User[3];

		users[0] = new User();
		users[0].setNickName("Alline Oliveira");
		users[0].setName("Alline.Oliveira");
		users[0].setPassword("bD8Km8se2rV9");

		users[1] = new User();
		users[1].setNickName("June Clarke");
		users[1].setName("joonspoon");
		users[1].setPassword("Vj6mz4MX9Wu7");

		users[2] = new User();
		users[2].setNickName("Alline Oliveira");
		users[2].setName("alline");
		users[2].setPassword("agile");

		return users;
	}
}
