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

@Table(name = "list")
@Entity
public class TodoList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int listId;

	private String title;

	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedOn;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public int getListId() {
		return listId;
	}

}
