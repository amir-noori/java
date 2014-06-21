package com.techcenter.ejb.ssb.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import com.techcenter.ejb.jpa.User;

@Remote
public interface UserDao
{
	public EntityManager getEntityManager();
	public User getUserByName(String name);
	public User getUserById(int id);
	public User getUserByMail(String mail);
	public List<User> getAllAdminUsers();
	public List<User> getAllSuperAdminUsers();
	public List<User> getAllUsers();
	public List<User> getAllUsers(int index , int num);
	public List<User> getAllUsersStartByLetter(String letter);
}
