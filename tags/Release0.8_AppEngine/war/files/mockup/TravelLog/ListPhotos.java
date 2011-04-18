package com.amazon.aws.samplecode.travellog.features.photos;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Entry;
import com.amazon.aws.samplecode.travellog.entity.Photo;

/** 
 * 
 * 
 * @Requirement 
 */

public class ListPhotos {

	/**
	 * Creates a map of photos tied to entry id's used to display photos in the
	 * UI
	 * 
	 * @param model
	 *            the spring model map to bring in request values
	 * @param entries
	 *            collection of entries that photos are attached to
	 */
	public ListPhotos(TravelLogDAO dao, ModelMap model,
			Collection<Entry> entries) {

		// Create a map of entries to photos
		Map<String, List<Photo>> photoMap = new LinkedHashMap<String, List<Photo>>();
		model.addAttribute("photoMap", photoMap);

		// SimpleDB doesn't have joins so querying these one at a time isn't
		// less efficient
		for (Entry entryItem : entries) {
			List<Photo> photos = dao.getPhotos(entryItem);
			photoMap.put(entryItem.getId(), photos);
		}
	}

}
