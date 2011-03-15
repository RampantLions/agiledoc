package sourceagile.client;

import sourceagile.client.systemNavigation.MainPage;
import sourceagile.shared.entities.User;

public class GlobalVariables {

	public static String locale;

	public static MainPage mainPage;

	public static String systemVersion = "Prototype Version 0.9";

	public static User currentUser = new User();

	public static boolean isReadyOnly = false;
}
