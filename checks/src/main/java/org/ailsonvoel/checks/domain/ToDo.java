package org.ailsonvoel.checks.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="todo")
@Entity
public class ToDo {

	@Id
	@Column(name="todoId")
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
	private String title;
	
	private String description;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="due_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	@Column(name="reminder_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reminderDate;
	
	@Column(name="modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	
	private String comment;
	
	private int statusId;
	
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	
	
}
