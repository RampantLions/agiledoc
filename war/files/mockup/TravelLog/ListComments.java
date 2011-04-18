package com.amazon.aws.samplecode.travellog.features.comments;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;
import com.amazon.aws.samplecode.travellog.entity.Entry;

/** 
 * 
 * 
 * @Requirement 
 */

public class ListComments {

	/**
	 * Creates a map of comments tied to entry id's used to display comments in
	 * the UI
	 * 
	 * @param model
	 *            the spring model map to bring in request values
	 * @param entries
	 *            collection of entries that comments are attached to
	 */
	public ListComments(TravelLogDAO dao, ModelMap model,
			Collection<Entry> entries) {

		// Create a map of entries to photos
		Map<String, List<Comment>> commentMap = new LinkedHashMap<String, List<Comment>>();
		model.addAttribute("commentMap", commentMap);

		// SimpleDB doesn't have joins so querying these one at a time isn't
		// less efficient
		for (Entry entryItem : entries) {
			List<Comment> photos = dao.getComments(entryItem);
			commentMap.put(entryItem.getId(), photos);
		}
	}

}
