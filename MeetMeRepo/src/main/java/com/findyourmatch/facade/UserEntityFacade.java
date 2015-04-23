/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.facade;

import com.findyourmatch.entities.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ASHOK
 */
@Stateless
public class UserEntityFacade extends AbstractFacade<UserEntity> {

    @PersistenceContext(unitName = "MeetMeRepoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(UserEntity.class);
    }

    public List<Object> findByName(String name, String password) {
        Query query = getEntityManager().createQuery("SELECT u FROM UserEntity u where u.username=:name AND u.password=:password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        return query.getResultList();
    }

    public List<UserEntity> findRecentUsers() {
        Query query = getEntityManager().createQuery("SELECT u FROM UserEntity u ORDER BY u.userDetailsID.updateDate DESC").setMaxResults(4);
        return (List<UserEntity>) query.getResultList();
    }
}
