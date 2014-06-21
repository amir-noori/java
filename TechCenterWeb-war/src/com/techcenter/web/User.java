package com.techcenter.web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean()
@SessionScoped()
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String mail;
	private boolean isAdmin = false;
	private boolean isSuperAdmin = false;
	private boolean logedIn = false;
		
	public User() 
	{
		
	}
	
	public void setUserName(String name)
	{
		this.userName = name;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	
	public String getMail()
	{
		return this.mail;
	}
	
	public void setIsAdmin(boolean is)
	{
		this.isAdmin = is;
	}
	
	public boolean getIsAdmin()
	{
		return this.isAdmin;
	}
	
	public void setIsSuperAdmin(boolean is)
	{
		this.isSuperAdmin = is;
	}
	
	public boolean getIsSuperAdmin()
	{
		return this.isSuperAdmin;
	}
	
	public void setLogedIn(boolean is)
	{
		this.logedIn = is;
	}
	
	public boolean getLogedIn()
	{
		return this.logedIn;
	}

}
