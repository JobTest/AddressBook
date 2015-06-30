package com.dao;

import com.domain.Role;

/**
 * Created by Саша on 29.06.2015.
 */
public interface RoleDAO {

    public void addRole(Role role);

    public Role getRole(String username);

    public void updateRole(Role role);

    public void removeRole(String username);

}
