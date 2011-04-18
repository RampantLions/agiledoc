package com.amazon.aws.samplecode.travellog.features.journal;

import java.util.Collection;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Entry;
import com.amazon.aws.samplecode.travellog.entity.Journal;

/** 
 * 
 * 
 * @Requirement 
 */

public class ListJournalEntries {

	public static Collection<Entry> list(TravelLogDAO dao, Journal journal) {

		Collection<Entry> entries = dao.getEntries(journal);

		return entries;
	}

}
