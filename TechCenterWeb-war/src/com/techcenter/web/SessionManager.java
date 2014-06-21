package com.techcenter.web;


import javax.servlet.http.HttpSession;
import javax.faces.context.*;

import com.techcenter.web.*;

public class SessionManager
{
	private HttpSession session;
	
	public SessionManager() 
	{
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	public void setSessionVariable(String var , String value)
	{
		session.setAttribute(var, value);
	}
	
}
