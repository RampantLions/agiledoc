package com.amazon.aws.samplecode.travellog.web;

import java.util.Collection;
import java.util.List;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;
import com.amazon.aws.samplecode.travellog.entity.Entry;
import com.amazon.aws.samplecode.travellog.entity.Journal;
import com.amazon.aws.samplecode.travellog.entity.Photo;
import com.amazon.aws.samplecode.travellog.entity.User;
import com.amazon.aws.samplecode.travellog.features.comments.ListComments;
import com.amazon.aws.samplecode.travellog.features.journal.ListJournalEntries;
import com.amazon.aws.samplecode.travellog.features.photos.ListPhotos;
import com.amazon.aws.samplecode.travellog.features.users.ListUsers;

/**
 * 
 * @Requirement
 */
public class Home {

	public Home(TravelLogDAO dao, ModelMap model) {

		Journal journal = dao.getJournal();

		List<User> users = ListUsers.list(dao, model);

		// Create placeholder objects for the various forms in the page
		if (model.get("entry") == null) {
			Entry entry = new Entry();
			model.addAttribute("entry", entry);
		}

		if (model.get("photo") == null) {
			Photo photo = new Photo();
			model.addAttribute("photo", photo);
		}

		if (model.get("comment") == null) {
			Comment comment = new Comment();
			model.addAttribute("comment", comment);
		}

		// If we have no journal it means this is a new journal, so bootstrap it
		if (journal == null) {

			Wizard.runWizard(dao, model);
			return;
		} else if (users.size() == 0) {

			// If we have no users, bootstrap it
			Wizard.runWizard(dao, model);
			return;
		}

		model.addAttribute("journal", journal);

		Collection<Entry> entries = ListJournalEntries.list(dao, journal);

		new ListPhotos(dao, model, entries);
		new ListComments(dao, model, entries);

		model.addAttribute("entries", entries);
	}

}
