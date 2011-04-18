package com.amazon.aws.samplecode.travellog.features.journal;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Entry;

public class GetJournal {

	public static Entry get(TravelLogDAO dao, String entryId) {

		Entry entry = dao.getEntry(entryId);

		return entry;
	}

}
