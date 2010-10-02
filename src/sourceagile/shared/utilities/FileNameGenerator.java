package sourceagile.shared.utilities;

public class FileNameGenerator {

	public static String compactName(String name) {

		return compactName(name, false);
	}

	public static String compactName(String name, boolean isFolder) {

		String[] words = (name.trim()).split(" ");

		String compressedFileName = "";

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			if (!isFolder || i > 0) {

				word = (word.substring(0, 1)).toUpperCase() + word.substring(1);
			}

			compressedFileName += word;
		}

		return compressedFileName;
	}

}
