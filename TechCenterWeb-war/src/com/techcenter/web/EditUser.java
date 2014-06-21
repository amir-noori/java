package com.techcenter.web;


import com.techcenter.ejb.ssb.*;
import com.techcenter.web.User;

import javax.ejb.EJB;
import java.util.List;
import java.util.HashMap;
import javax.annotation.PostConstruct;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

public class EditUser 
{
	@EJB
	private static UserManager userManager;
	private FacesContext fc;
	private HashMap<String , String> userInfoList;
	
	public EditUser() 
	{
		userInfoList = new HashMap<String , String>();
	}
	
	@PostConstruct
	public void init()
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String index = ec.getRequestParameterMap().get("edit");
		
		System.out.println("\n\n\nedit: \nAAAAAAxx\n\n"+index+"\n\naaaaaaa\n\n");
		if(index == null)
		{
			System.out.println("\n\n\nedit: \nAAAAAAxx\n\n"+index+"\n\naaaaaaa\n\n");
		}
		else
		{
			this.userInfoList = userManager.getUserInfoList(index);
		}
	}
	
	public void setUserInfoList(HashMap info)
	{
		this.userInfoList = info;
	}
	
	public void setUserInfoList(String key , String value)
	{
		this.userInfoList.put(key , value);
	}
	
	public HashMap getUserInfoList()
	{
		return this.userInfoList;
	}
	
	public void editNav()
	{

		System.out.println("\n\n\n\n\n$$$$$$$$$$xx2\n\n\n\n\n");
		fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav  = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
		nav.performNavigation("editUser");
		System.out.println("\n\n\n\n\n$$$$$$$$$$xx2\n\n\n\n\n");

	}
	
	public HashMap edit()
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String index = ec.getRequestParameterMap().get("edit");
		
		System.out.println("\n\n\nedit: \nAAAAAA\n\n"+index+"\n\naaaaaaa\n\n");
		
		//HashMap userInfoList = userManager.getUserInfoList(index);
		return this.userInfoList;
	}
	
	public void saveInfo()
	{
		System.out.println("\n\n\n\nUserInfo: " + userInfoList.get("id") +userInfoList.get("mail")+ userInfoList.get("userName") + "\n\n\n\n");
	}
	
	
	public void delete()
	{
		
	}
}
