package sourceagile.server.databaseAccess.entities;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ProjectBacklog implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long projectBacklogID;

	@Persistent
	private String backlogName;

	@Persistent
	@Column(jdbcType = "LONGVARCHAR")
	private String backlogDescription;

	@Persistent
	private Date backlogDate;

	@Persistent
	private Integer backlogPriority;

	@Persistent
	private Integer backlogEstimative;

	@Persistent
	private String backlogStatus;

	public Long getProjectBacklogID() {
		return projectBacklogID;
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