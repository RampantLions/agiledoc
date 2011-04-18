package com.amazon.aws.samplecode.travellog.features.journal;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Journal;
import com.amazon.aws.samplecode.travellog.util.Configuration;
import com.amazon.aws.samplecode.travellog.util.DataLoader;

/**
 * Add a description to every day of a trip.
 * 
 * @MainFeature
 */
public class CreateJournal {

	public CreateJournal(TravelLogDAO dao, Journal journal,
			BindingResult result, boolean preload, ModelMap map, Logger logger) {

		// If we're preloading the sample, just skip to the preload method
		if (preload) {
			preloadJournal(dao, logger);
		} else {
			if (journal.getTitle().length() == 0) {
				result.reject("title", "Title cannot be blank");
			}

			// check to make sure we don't already have a journal
			if (dao.getJournals().size() > 0) {
				result.reject("title",
						"Journal already exists.  Please reload page.");
			}

			if (!result.hasErrors()) {
				dao.saveJournal(journal);
			}
		}

	}

	private void preloadJournal(TravelLogDAO dao, Logger logger) {

		Configuration config = Configuration.getInstance();
		String bucket = config.getProperty("bundleBucket");
		String path = config.getProperty("bundlePath");
		DataLoader loader = new DataLoader(bucket, path, dao);
		Thread thread = new Thread(loader);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}

}
