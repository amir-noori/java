package com.techcenter.ejb.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */

@Entity
@Table(name="address")
public class Address implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	//primary key
	@Id
	private int id;
	
	//fields
	private String city;
	private String streetAddress;
	private String postalCode;

	//no argument constructor
	public Address()
	{
		super();
	}

	
	
	//seters & geters
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	
	public String getStreetAddress()
	{
		return this.streetAddress;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public String getPostalcode()
	{
	 return this.postalCode;
	}
	//seters & geters end
	
	
	public boolean isEqual(Address add)
	{
		if((this.city.equals(add.city)) && (this.streetAddress.equals(add.streetAddress)) && (this.postalCode.equals(add.postalCode)))
		{return true;}
		else
		{return false;}
	}
	
}