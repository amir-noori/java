package com.techcenter.web;

import javax.ejb.EJB;
import java.util.List;

import com.techcenter.ejb.ssb.UserSearch;

public class UserSearchBean 
{
	@EJB
	private static UserSearch userSearch;
	private String searchString = null;
	
	public UserSearchBean() 
	{
	}
	
	public void setSearchString(String sc)
	{
		this.searchString = sc;
	}
	
	public String getSearchString()
	{
		return this.searchString;
	}
	
	public List<String> searchAll()
	{
		List<String> results = userSearch.searchUserByUserName(searchString);
		if(results.isEmpty())
		{
			return null;
		}
		else
		{
			return results;
		}
	}
}
