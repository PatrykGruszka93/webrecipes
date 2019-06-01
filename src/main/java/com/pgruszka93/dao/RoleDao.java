package com.pgruszka93.dao;


import com.pgruszka93.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
