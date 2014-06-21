package com.techcenter.ejb.ssb;

import java.util.List;
import java.util.HashMap;

import javax.ejb.Remote;

import com.techcenter.ejb.jpa.User;

@Remote
public interface UserManager 
{
	public boolean userExist(String userName , String password);
	public boolean isAdmin(String userName);
	public boolean isSuperAdmin(String userName);
	
	public List<String> getAllAdminUsersNames();
	public List<String> getAllSuperAdminUsersNames();
	public List<String> getAllUsersNames();
	
	
	public HashMap<String , List<String>> getAllSuperAdminInfoList();
	public HashMap<String , List<String>> getAllAdminInfoList();
	public HashMap<String , List<String>> getAllUserInfoList(int index , int num);
	public HashMap<String , String> getUserInfoList(String userName);
	
	public List<String> getAllUsersStartByLetter(String letter);
	
	public int getNumberOfAllUsers();
	
}
