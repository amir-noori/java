package com.techcenter.ejb.ssb;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserSearch
{
	public List<String> searchUserByUserName(String searchString);
}
