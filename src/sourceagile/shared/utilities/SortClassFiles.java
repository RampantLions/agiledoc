package sourceagile.shared.utilities;

import java.util.Arrays;
import java.util.HashMap;

import sourceagile.shared.entities.entry.ClassFile;

public class SortClassFiles {

	public static ClassFile[] getSortedArray(
			HashMap<String, ClassFile> classesMap) {

		ClassFile[] entries = new ClassFile[classesMap.size()];

		classesMap.values().toArray(entries);

		Arrays.sort(entries);

		return entries;
	}

}
