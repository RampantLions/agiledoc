package com.amazon.aws.samplecode.travellog.features.photos;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.aws.S3PhotoUtil;
import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Photo;

/** 
 * 
 * 
 * @Requirement 
 */

public class DeletePhoto {

	public static void delete(TravelLogDAO dao, Photo photo, ModelMap map) {

		S3PhotoUtil.deletePhotoFromS3(photo);
		dao.deletePhoto(photo);

	}

}
