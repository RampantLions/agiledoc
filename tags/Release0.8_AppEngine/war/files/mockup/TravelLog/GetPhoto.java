package com.amazon.aws.samplecode.travellog.features.photos;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Photo;

public class GetPhoto {

	public static Photo get(TravelLogDAO dao, String photoId) {

		Photo photo = dao.getPhoto(photoId);

		return photo;

	}

}
