package com.pgruszka93.dao;


import com.pgruszka93.entity.Recipe;
import com.pgruszka93.entity.Role;
import com.pgruszka93.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.AccessControlException;
import java.util.Collection;

@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public Collection<User> findAllUsers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("select u from User u order by u.userName");

		Collection<User> users = query.list();

		return users;
	}

    @Override
    public void changeEnableStatus(long userId) throws AccessControlException{
        Session currentSession = sessionFactory.getCurrentSession();
        if(checkIfIsAdmin(userId)){
            throw new AccessControlException("Administrators can't be disabled.");

        }
        boolean userEnabled = checkEnableStatus(userId);

        Query<User> query = currentSession.createQuery("update User set active =:enableStatus where id=:userId");

        query.setParameter("userId",userId);
        if(userEnabled){
        	query.setParameter("enableStatus", false);
		} else {
        	query.setParameter("enableStatus", true);
		}

        query.executeUpdate();
    }

    private boolean checkEnableStatus(long userId){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Boolean> query = currentSession.createQuery("select u.active from User u where id=:userId");
		query.setParameter("userId",userId);
		boolean result = query.getSingleResult();

		return result;
	}

	private boolean checkIfIsAdmin(long userId){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Role> query = currentSession.createQuery("select u.roles from User u where u.id=:userId");
        query.setParameter("userId",userId);
        Collection<Role> result = query.list();
        for(Role role : result){
            System.out.println(role.getName());
            if(role.getName().equals("ROLE_ADMIN")){
                return true;
            }
        }
        return false;
    }




}
