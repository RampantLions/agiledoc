package com.amazon.aws.samplecode.travellog.features.journal;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Entry;

/** 
 * 
 * 
 * @Requirement 
 */

public class DeleteJournal {

	public static void delete(TravelLogDAO dao, String entryId) {

		Entry entry = GetJournal.get(dao, entryId);
		dao.deleteEntry(entry);

	}

}
