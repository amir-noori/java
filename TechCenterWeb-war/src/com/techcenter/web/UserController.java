package com.techcenter.web;


import com.techcenter.ejb.ssb.*;
import com.techcenter.web.User;

import javax.ejb.EJB;
import java.util.List;
import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private static UserManager userManager;	
	private User user;
	private FacesContext fc;
	

	public UserController() 
	{
		user = new User();
		
	}
	
	public User getUser()
	{
		return this.user; 
	}
	
	public boolean checkUser(String name , String pass)
	{

		
		if(userManager.userExist(name , pass))
		{
			user.setLogedIn(true);

			if(userManager.isSuperAdmin(name))
			{
				user.setIsSuperAdmin(true);
				user.setIsAdmin(true);
			}
			else if(userManager.isAdmin(name))
			{
				user.setIsAdmin(true);
			}
			else
			{
				user.setIsSuperAdmin(false);
				user.setIsAdmin(false);
			}
			
			return true;
		}
		else
		{
			user.setIsSuperAdmin(false);
			user.setIsAdmin(false);
			return false;
		}

	}
	
	public boolean isLogedIn()
	{
		if(user.getLogedIn())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void accessDenied()
	{
		System.out.println("\n\n\n\n\n$$$$$$$$$$\n\n\n\n\n");
		if(!(user.getLogedIn()))
		{
			fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav 
			   = (ConfigurableNavigationHandler) 
				fc.getApplication().getNavigationHandler();
	 
				nav.performNavigation("access-denied");
		}

	}
	
}
