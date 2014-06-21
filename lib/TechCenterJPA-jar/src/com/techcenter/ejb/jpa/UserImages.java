package com.techcenter.ejb.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.techcenter.ejb.jpa.*;

@Entity(name="userimages")

public class UserImages implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="path")
	private String path;
	@Column(name="isProfile")
	private boolean isProfile;
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;

	
	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}
	
	public UserImages() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}   
	public boolean getIsProfile() {
		return this.isProfile;
	}

	public void setIsProfile(boolean isProfile) {
		this.isProfile = isProfile;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
