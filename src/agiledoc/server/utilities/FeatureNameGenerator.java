package agiledoc.server.utilities;

/**
 * @task
 */
public class FeatureNameGenerator {

	/**
	 * Return the last name of a names sequence separated by dots already
	 * separated by spaces between the upper case letters.
	 */
	public static String getLastNameSpaced(String fullName, String splitChar) {

		return spacedName(getLastName(fullName, splitChar));
	}

	/**
	 * Return the last name of a names sequence separated by dots.
	 */
	public static String getLastName(String fullName, String splitChar) {

		String[] names = fullName.split(splitChar);
		String lastName = names[names.length - 1];

		return lastName;
	}

	public static String getFileSpacedName(String fileName) {

		return spacedName(removeFileExtension(fileName));
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

		String spacedName = null;

		if (name.length() > 0) {

			String[] words = (name.substring(1)).split("[A-Z]");

			spacedName = name.substring(0, 1).toUpperCase() + words[0];

			int position = spacedName.length();

			for (int i = 1; i < words.length; i++) {

				String firstLetter = name.substring(position, position + 1);

				spacedName += " " + firstLetter.toUpperCase() + words[i];

				position += (words[i].length() + 1);
			}

		} else {
			
			spacedName = name.toUpperCase();
		}

		return spacedName;
	}

}
