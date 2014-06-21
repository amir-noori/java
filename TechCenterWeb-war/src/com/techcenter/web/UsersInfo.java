package com.techcenter.web;

import com.techcenter.ejb.ssb.*;
import com.techcenter.web.User;

import javax.ejb.EJB;
import java.util.List;
import java.util.HashMap;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class UsersInfo 
{
	
	@EJB
	private static UserManager userManager;
	
	public UsersInfo() 
	{
		
	}
	
	public List<String> getAllAdmins()
	{
		return userManager.getAllAdminUsersNames();
	}
	
	public List<String> getAllSuperAdmins()
	{
		return userManager.getAllSuperAdminUsersNames();
	}
	
	public List<String> getAllUsers()
	{
		return userManager.	getAllUsersNames();
	}
	
	public HashMap<String , List<String>> getAllSuperAdminInfoList()
	{
		HashMap info =  userManager.getAllSuperAdminInfoList();
		return info;
	}
	
	public HashMap<String , List<String>> getAllAdminInfoList()
	{
		HashMap info =  userManager.getAllAdminInfoList();
		return info;
	}
	
	public HashMap<String , List<String>> getAllUserInfoList(int num)
	{
		int x;
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String index = ec.getRequestParameterMap().get("scrollIndex");
		if(index == null)
		{
			x = 0;
		}
		else
		{
			x = Integer.parseInt(index);
		}
		HashMap info =  userManager.getAllUserInfoList(x*15 , num);
		return info;
	}

	public int handleTabChange()
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String index = ec.getRequestParameterMap().get("roleIndex");
		if(index == null)
		{
			return 3;
		}
		else
		{
			return Integer.parseInt(index);
		}
	}
	
	public int countUsers()
	{
		int num = userManager.getNumberOfAllUsers();
		return num;
	}
}
