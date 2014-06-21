package com.techcenter.ejb.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */


@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="findUserByName" , query="SELECT u FROM User u  WHERE u.userName=:userName ORDER BY u.userName ASC"),
	@NamedQuery(name="findUserById" , query="SELECT u FROM User u WHERE u.id=:id ORDER BY u.userName ASC"),
	@NamedQuery(name="findUserByMail" , query="SELECT u FROM User u WHERE u.userMail=:mail ORDER BY u.userName ASC"),
	@NamedQuery(name="findAllAdminUsers" , query="SELECT u FROM User u WHERE u.isAdmin=(true) ORDER BY u.userName ASC"),
	@NamedQuery(name="findAllSuperAdminUsers" , query="SELECT u FROM User u WHERE u.isSuperAdmin=(true) ORDER BY u.userName ASC"),
	@NamedQuery(name="findAllUsers" , query="SELECT u FROM User u WHERE u.isAdmin=(FALSE) ORDER BY u.userName ASC"),
	@NamedQuery(name="findAllUsersStartByLetter" , query="SELECT u FROM User u WHERE LOCATE(:letter , u.userName) = 1 ORDER BY u.userName ASC"),
	@NamedQuery(name="countUsers" , query="SELECT COUNT(u) FROM User u WHERE u.isAdmin=(FALSE)"),
})
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	//primary key
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	//fields
	@Column(name="userName")
	private String  userName;
	@Column(name="password")
	private String  password;
	@Column(name="userMail")
	private String  userMail;
	@Column(name="isAdmin")
	private boolean isAdmin;
	@Column(name="isSuperAdmin")
	private boolean isSuperAdmin;
	
	//no argument constructor
	public User()
	{
		super();
	}
	
	//seters & geters
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setUserMail(String userMail)
	{
		this.userMail = userMail;
	}
	
	public String getUserMail()
	{
		return this.userMail;
	}
	
	public void setIsAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	
	public boolean getIsAdmin()
	{
		return this.isAdmin;
	}
	
	public void setIsSuperAdmin(boolean isSuperAdmin)
	{
		this.isSuperAdmin = isSuperAdmin;
	}
	
	public boolean getIsSuperAdmin()
	{
		return this.isSuperAdmin;
	}
	//seters & geters end
	
	public boolean isEqual(User user)
	{
		if((this.userName.equals(user.userName)) && (this.id == user.id))
			return true;
		else
			return false;
	}
}