/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.entities.UserAddressEntity;
import com.findyourmatch.entities.UserDetailsEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ASHOK
 */
@Named("prof")
@SessionScoped
public class ProfileController implements Serializable {
    private UserDetailsEntity details;
    private UserAddressEntity address;    
    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
    }

    public UserDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(UserDetailsEntity details) {
        this.details = details;
    }

    public UserAddressEntity getAddress() {
        return address;
    }

    public void setAddress(UserAddressEntity address) {
        this.address = address;
    }
}
