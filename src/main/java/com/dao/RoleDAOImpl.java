package com.dao;

import com.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Саша on 30.06.2015.
 */

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Role getRole(String username) {
        Role role = (Role) sessionFactory.getCurrentSession().get(Role.class, username);

        return role;
    }

    @Override
    public void updateRole(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void removeRole(String username) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, username);

        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }
}
