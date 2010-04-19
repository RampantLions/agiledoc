package com.agiledoc.server.sourceTags;

import com.agiledoc.server.util.ChangeNames;
import com.agiledoc.shared.model.Classe;
import com.sun.javadoc.Tag;

/**
 * @task
 * 
 * @author allineo
 * @modified 04/15/2010
 */
public class SourceTags {

	/**
	 * List the link tags.
	 * 
	 * @author allineo
	 * @modified 04/15/2010
	 */
	public static Classe[] list(Tag[] tags) {

		Classe[] links = new Classe[tags.length];

		for (int t = 0; t < tags.length; t++) {

			links[t] = new Classe();
			links[t].setFullName(tags[t].text());
			links[t].setName(ChangeNames.spacedName(ChangeNames
					.getLastName(tags[t].text())));
		}

		return links;
	}
}
