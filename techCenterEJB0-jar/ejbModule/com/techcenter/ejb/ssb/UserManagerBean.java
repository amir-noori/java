package com.techcenter.ejb.ssb;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import com.techcenter.ejb.ssb.dao.*;
import com.techcenter.ejb.jpa.User;
import com.techcenter.ejb.ssb.UserManager;
import com.techcenter.ejb.ssb.dao.*;

@Stateless(name="UserManagerBean")
public class UserManagerBean implements UserManager 
{
	@EJB
	private UserDao userDao;
	
	public UserManagerBean()
	{
	}
	
	public boolean userExist(String userName , String password)
	{
		try{
		User user = userDao.getUserByName(userName);
			if((user.getUserName().equals(userName)) && (user.getPassword().equals(password)))
				return true;
			else 
				return false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<String> getAllAdminUsersNames()
	{
		
		try{
			List<User> users = userDao.getAllAdminUsers();
			List<String> usersNames = new ArrayList<String>();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				usersNames.add(users.get(i).getUserName());
			}
			return usersNames;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<String> getAllSuperAdminUsersNames()
	{
		
		try{
			List<User> users = userDao.getAllSuperAdminUsers();
			List<String> usersNames = new ArrayList<String>();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				usersNames.add(users.get(i).getUserName());
			}
			return usersNames;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean isAdmin(String userName)
	{
		try{
		User user = userDao.getUserByName(userName);
			if(user.getIsAdmin())
				return true;
			else 
				return false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean isSuperAdmin(String userName)
	{
		try{
		User user = userDao.getUserByName(userName);
			if(user.getIsSuperAdmin())
				return true;
			else 
				return false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<String> getAllUsersNames()
	{
		try{
			List<User> users = userDao.getAllUsers();
			List<String> usersNames = new ArrayList<String>();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				usersNames.add(users.get(i).getUserName());
			}
			return usersNames;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<String> getAllUsersStartByLetter(String letter)
	{
		try{
			List<User> users = userDao.getAllUsersStartByLetter(letter);
			List<String> usersNames = new ArrayList<String>();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				usersNames.add(users.get(i).getUserName());
			}
			return usersNames;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String , List<String>> getAllSuperAdminInfoList()
	{
		try{
			List<User> users = userDao.getAllSuperAdminUsers();
			HashMap<String , List<String>> map = new HashMap();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				List<String> userInfo = new ArrayList<String>();
				userInfo.add(Integer.toString(users.get(i).getId()));
				userInfo.add(users.get(i).getUserName());
				userInfo.add(users.get(i).getUserMail());
				map.put(users.get(i).getUserName() , userInfo);
			}
			return map;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String , List<String>> getAllAdminInfoList()
	{
		try{
			List<User> users = userDao.getAllAdminUsers();
			HashMap<String , List<String>> map = new HashMap();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				List<String> userInfo = new ArrayList<String>();
				userInfo.add(Integer.toString(users.get(i).getId()));
				userInfo.add(users.get(i).getUserName());
				userInfo.add(users.get(i).getUserMail());
				map.put(users.get(i).getUserName() , userInfo);
			}
			return map;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String , List<String>> getAllUserInfoList(int index , int num)
	{
		try{
			List<User> users = userDao.getAllUsers(index , num);
			HashMap<String , List<String>> map = new HashMap();
			for (int i = 0 ; i < users.size() ; i ++)
			{ 
				List<String> userInfo = new ArrayList<String>();
				userInfo.add(Integer.toString(users.get(i).getId()));
				userInfo.add(users.get(i).getUserName());
				userInfo.add(users.get(i).getUserMail());
				map.put(users.get(i).getUserName() , userInfo);
			}
			return map;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String , String> getUserInfoList(String userName)
	{
		try{
			User user = userDao.getUserByName(userName);
			HashMap<String , String> map = new HashMap();
	
			try
			{
				map.put("id" , Integer.toString(user.getId()));
				map.put("userName" , user.getUserName());
				map.put("password" , user.getPassword());
				map.put("mail" , user.getUserMail());
				map.put("isAdmin" , Boolean.toString(user.getIsAdmin()));
				map.put("isSuperAdmin" , Boolean.toString(user.getIsSuperAdmin()));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return map;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getNumberOfAllUsers()
	{
		Query query = userDao.getEntityManager().createNamedQuery("countUsers");
		int num = ((Long)query.getSingleResult()).intValue();
		return num;
	}
	
}
