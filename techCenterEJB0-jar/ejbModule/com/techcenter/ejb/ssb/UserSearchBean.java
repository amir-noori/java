package com.techcenter.ejb.ssb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.techcenter.ejb.ssb.UserSearch;

@Stateless 
public class UserSearchBean implements UserSearch 
{
	@PersistenceContext(unitName = "TechCenterUnit")
	protected EntityManager em;

	
	@SuppressWarnings("unchecked")
	public List<String> searchUserByUserName(String searchString)
	{	
		List<String> resultNames;
		try
		{
			String q = "SELECT u.userName FROM User u  WHERE u.userName LIKE :userName ORDER BY u.userName ASC";
			Query query = em.createQuery(q);
			query.setParameter("userName", "%" + searchString + "%");
			resultNames = query.getResultList();
			return resultNames;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
