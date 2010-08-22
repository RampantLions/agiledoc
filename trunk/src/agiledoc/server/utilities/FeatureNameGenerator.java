package agiledoc.server.utilities;

/**
 * @task
 */
public class FeatureNameGenerator {

	/**
	 * Return the last name of a names sequence separated by dots already
	 * separated by spaces between the upper case letters.
	 */
	public static String getLastNameSpaced(String fullName) {

		return spacedName(getLastName(fullName));
	}

	/**
	 * Return the last name of a names sequence separated by dots.
	 */
	public static String getLastName(String fullName) {

		String[] names = fullName.split("\\.");
		String lastName = names[names.length - 1];

		return lastName;
	}
	
	/**
	 * Return the name of the file without its extension after the "."
	 */
	public static String removeFileExtension(String fileName) {
		
		String[] names = fileName.split("\\.");
		String name = names[0];

		return name;
	}

	/**
	 * Fill with spaces a name that is truncated.
	 */
	public static String spacedName(String name) {

		String[] words = (name.substring(1)).split("[A-Z]");

		String spacedName = name.substring(0, 1).toUpperCase() + words[0];

		int position = spacedName.length();

		for (int i = 1; i < words.length; i++) {

			String firstLetter = name.substring(position, position + 1);

			spacedName += " " + firstLetter.toUpperCase() + words[i];

			position += (words[i].length() + 1);
		}

		return spacedName;
	}

}
