/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.facade;

import com.findyourmatch.entities.UserDetailsEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASHOK
 */
@Stateless
public class UserDetailsEntityFacade extends AbstractFacade<UserDetailsEntity> {
    @PersistenceContext(unitName = "MeetMeRepoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDetailsEntityFacade() {
        super(UserDetailsEntity.class);
    }
    
}
