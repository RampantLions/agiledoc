package sourceagile.shared.entities;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @entity
 */
@PersistenceCapable
public class Comments implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long commmentID;

	@Persistent
	private String commentAuthor;

	@Persistent
	private Date commentDate;

	@Persistent
	@Column(jdbcType = "LONGVARCHAR")
	private String commentDescription;

	@Persistent
	private Long commentProject;

	@Persistent
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
