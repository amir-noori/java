package com.techcenter.ejb.ssb.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.*;
import javax.ejb.Stateless;


@Stateless(name="BaseDaoBean")
public abstract class BaseDaoBean implements BaseDao
{		
	public BaseDaoBean()
	{

	}

}
