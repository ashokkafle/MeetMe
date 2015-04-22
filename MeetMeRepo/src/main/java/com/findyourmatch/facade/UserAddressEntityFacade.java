/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.facade;

import com.findyourmatch.entities.UserAddressEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASHOK
 */
@Stateless
public class UserAddressEntityFacade extends AbstractFacade<UserAddressEntity> {
    @PersistenceContext(unitName = "MeetMeRepoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAddressEntityFacade() {
        super(UserAddressEntity.class);
    }
    
}
