package com.amazon.aws.samplecode.travellog.features.comments;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;

public class GetComment {

	public static Comment get(TravelLogDAO dao, String commentId, ModelMap map) {

		Comment comment = dao.getComment(commentId);

		return comment;

	}

}
