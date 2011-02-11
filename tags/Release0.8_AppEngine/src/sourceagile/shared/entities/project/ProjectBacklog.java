package sourceagile.shared.entities.project;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Entity
 */
public class ProjectBacklog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long projectBacklogID;

	private String backlogName;

	private String backlogDescription;

	private Date backlogDate;

	private Integer backlogPriority;

	private Integer backlogEstimative;

	private String backlogStatus;

	public Long getProjectBacklogID() {
		return projectBacklogID;
	}

	public void setProjectBacklogID(Long projectBacklogID) {
		this.projectBacklogID = projectBacklogID;
	}

	public String getBacklogName() {
		return backlogName;
	}

	public void setBacklogName(String backlogName) {
		this.backlogName = backlogName;
	}

	public String getBacklogDescription() {
		return backlogDescription;
	}

	public void setBacklogDescription(String backlogDescription) {
		this.backlogDescription = backlogDescription;
	}

	public Date getBacklogDate() {
		return backlogDate;
	}

	public void setBacklogDate(Date backlogDate) {
		this.backlogDate = backlogDate;
	}

	public Integer getBacklogPriority() {
		return backlogPriority;
	}

	public void setBacklogPriority(Integer backlogPriority) {
		this.backlogPriority = backlogPriority;
	}

	public Integer getBacklogEstimative() {
		return backlogEstimative;
	}

	public void setBacklogEstimative(Integer backlogEstimative) {
		this.backlogEstimative = backlogEstimative;
	}

	public String getBacklogStatus() {
		return backlogStatus;
	}

	public void setBacklogStatus(String backlogStatus) {
		this.backlogStatus = backlogStatus;
	}

}