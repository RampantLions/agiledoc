package com.amazon.aws.samplecode.travellog.features.comments;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;

/** 
 * 
 * 
 * @Requirement 
 */

public class DeleteComment {

	public static void doDelete(TravelLogDAO dao, Comment comment) {

		dao.deleteComment(comment);

	}

}
