package com.amazon.aws.samplecode.travellog.features.photos;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.amazon.aws.samplecode.travellog.aws.S3PhotoUtil;
import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Photo;

/** 
 * 
 * 
 * @MainFeature 
 */

public class UploadPhoto {

	public static void savePhoto(TravelLogDAO dao, Photo photo,
			MultipartFile file) throws IOException {

		// We must save photo to ensure we have a photo ID for storing
		// images on S3
		dao.savePhoto(photo);

		// A file has been uploaded so do a full storage routine
		photo = S3PhotoUtil.storePhoto(photo, file.getBytes());
		dao.savePhoto(photo);

	}

	public static void updatePhoto(TravelLogDAO dao, Photo photo) {

		// Updating existing photo

		// Need to grab the paths to the photos from the database
		// as these aren't changeable except by an upload
		Photo originalPhoto = dao.getPhoto(photo.getId());
		photo.setOriginalPath(originalPhoto.getOriginalPath());
		photo.setWebsizePath(originalPhoto.getWebsizePath());
		photo.setThumbnailPath(originalPhoto.getThumbnailPath());

		// No uploaded photo so just save the updated data
		dao.savePhoto(photo);

	}

}
