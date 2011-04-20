package sourceagile.shared.utilities;

import sourceagile.shared.entities.project.Project;

public class FeatureNameGenerator {

	/**
	 * Return the last name of a names sequence separated by dots already
	 * separated by spaces between the upper case letters.
	 */
	public static String getLastNameSpaced(String fullName, String splitChar,
			String locale) {

		return spacedName(getLastName(fullName, splitChar), locale);
	}

	/**
	 * Return the last name of a names sequence separated by dots.
	 */
	public static String getLastName(String fullName, String splitChar) {

		String[] names = fullName.split(splitChar);
		String lastName = names[names.length - 1];

		return lastName;
	}

	public static String getFileSpacedName(String fileName, String locale) {

		return spacedName(removeFileExtension(fileName), locale);
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
	public static String spacedName(String name, String locale) {

		String spacedName = name;

		if (name.length() > 0) {

			String[] words = (name.substring(1)).split("[A-Z]");

			if (words.length > 0) {

				spacedName = name.substring(0, 1).toUpperCase() + words[0];

				int wordPosition = spacedName.length();

				for (int i = 1; i < words.length; i++) {

					String firstLetter = name.substring(wordPosition,
							wordPosition + 1);

					if (verifyPortugueseJunctions(firstLetter + words[i],
							locale)) {

						firstLetter = firstLetter.toLowerCase();

					} else {

						firstLetter = firstLetter.toUpperCase();
					}

					spacedName += " " + firstLetter + words[i];

					wordPosition += (words[i].length() + 1);
				}

			} else {

				spacedName = name.toUpperCase();
			}
		}
		return spacedName;
	}

	public static boolean verifyPortugueseJunctions(String word, String locale) {

		boolean isJunction = false;

		if ((Project.LOCALE_PORTUGUESE).equals(locale)) {

			if (word.toLowerCase().equals("o")
					|| word.toLowerCase().equals("os")
					|| word.toLowerCase().equals("de")
					|| word.toLowerCase().equals("um")
					|| word.toLowerCase().equals("a")
					|| word.toLowerCase().equals("as")
					|| word.toLowerCase().equals("e")
					|| word.toLowerCase().equals("do")
					|| word.toLowerCase().equals("dos")
					|| word.toLowerCase().equals("da")
					|| word.toLowerCase().equals("das")
					|| word.toLowerCase().equals("no")
					|| word.toLowerCase().equals("nos")
					|| word.toLowerCase().equals("na")
					|| word.toLowerCase().equals("nas")
					|| word.toLowerCase().equals("para")
					|| word.toLowerCase().equals("com")) {

				isJunction = true;
			}
		}

		return isJunction;
	}

}
