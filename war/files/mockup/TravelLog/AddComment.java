package com.amazon.aws.samplecode.travellog.features.comments;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import com.amazon.aws.samplecode.travellog.aws.TravelLogSNSManager;
import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;
import com.amazon.aws.samplecode.travellog.entity.Entry;

/**
 * Any user can add comments to a journal in the system.
 * 
 * TODO: Automatically shows the user name as default on the add comments form.
 * 
 * @ToDo
 * @MainFeature
 */
public class AddComment {

	public static void verifyComment(Comment comment, BindingResult result) {

		if (comment.getBody().length() == 0) {
			result.reject("body", "You did not enter a comment");
		}

		if (comment.getCommenter().getName().length() == 0) {
			result.reject("commenter.name", "You must enter a name");
		}
	}

	public static void addComment(TravelLogDAO dao, Comment comment,
			HttpServletRequest request) {

		Entry entry = dao.getEntry(comment.getEntry().getId());
		comment.setEntry(entry);
		comment.setDate(Calendar.getInstance().getTime());
		dao.saveCommenter(comment.getCommenter());
		dao.saveComment(comment);

		TravelLogSNSManager sns = new TravelLogSNSManager();
		if (request.getParameter("emailComments") != null) {
			sns.subscribe(entry, comment.getCommenter());
		}

		sns.publish(entry, comment);

	}

}
