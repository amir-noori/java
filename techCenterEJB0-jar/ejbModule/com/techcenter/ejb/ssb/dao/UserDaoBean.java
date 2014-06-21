package com.techcenter.ejb.ssb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.techcenter.ejb.jpa.*;
import com.techcenter.ejb.ssb.dao.*;

@Stateless(name="UserDaoBean")
public class UserDaoBean extends BaseDaoBean implements UserDao
{
	private BaseDaoBean baseDao;
	@PersistenceContext(unitName = "TechCenterUnit")
	protected EntityManager em;
	
	public UserDaoBean()
	{
	}
	
	public EntityManager getEntityManager()
	{
		return this.em;
	}
	
	public User getUserByName(String name)
	{
		Query query = em.createNamedQuery("findUserByName");

		query.setParameter("userName", name);
		User result = (User)query.getSingleResult();
		return result;
	}
	public User getUserById(int id)
	{
		Query query = em.createNamedQuery("findUserById");
		query.setParameter("id", id);
		User result = (User)query.getSingleResult();
		return result;
	}
	public User getUserByMail(String mail)
	{
		Query query = em.createNamedQuery("findUserByMail");
		query.setParameter("mail", mail);
		User result = (User)query.getSingleResult();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllAdminUsers()
	{
		Query query = em.createNamedQuery("findAllAdminUsers");
		List<User> result = (List<User>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllSuperAdminUsers()
	{
		Query query = em.createNamedQuery("findAllSuperAdminUsers");
		List<User> result = (List<User>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		Query query = em.createNamedQuery("findAllUsers");
		List<User> result = (List<User>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(int index , int num)
	{
		Query query = em.createNamedQuery("findAllUsers");
		query.setFirstResult(index).setMaxResults(num);
		List<User> result = (List<User>)query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsersStartByLetter(String letter)
	{
		Query query = em.createNamedQuery("findAllUsersStartByLetter");
		query.setParameter("letter", letter);
		List<User> result = (List<User>)query.getResultList();
		return result;
	}
}
