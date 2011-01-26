package sourceagile.shared.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Entity
 */
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long commmentID;

	private String commentAuthor;

	private Date commentDate;

	private String commentDescription;

	private Long commentProject;

	private String commentClass;

	public Long getCommmentID() {
		return commmentID;
	}

	public void setCommmentID(Long commmentID) {
		this.commmentID = commmentID;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Long getCommentProject() {
		return commentProject;
	}

	public void setCommentProject(Long commentProject) {
		this.commentProject = commentProject;
	}

	public String getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(String commentClass) {
		this.commentClass = commentClass;
	}

}
