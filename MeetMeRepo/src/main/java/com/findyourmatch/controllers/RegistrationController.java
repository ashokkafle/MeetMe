/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.entities.UserAddressEntity;
import com.findyourmatch.entities.UserDetailsEntity;
import com.findyourmatch.entities.UserEntity;
import com.findyourmatch.facade.UserAddressEntityFacade;
import com.findyourmatch.facade.UserDetailsEntityFacade;
import com.findyourmatch.facade.UserEntityFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ASHOK
 */
@Named("reg")
@SessionScoped
public class RegistrationController implements Serializable {
    @EJB
    private UserEntityFacade userEntityFacade;
    @EJB
    private UserAddressEntityFacade userAddressEntityFacade;
    @EJB
    private UserDetailsEntityFacade userDetailsEntityFacade;
    
    private UserEntity userEntity;
    private UserAddressEntity userAddress;
    private UserDetailsEntity userDetails;
    
    private String password;
    private String rePassword;
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationController() {
        userEntity = new UserEntity();
        userAddress = new UserAddressEntity();
        userDetails = new UserDetailsEntity();
    }

    public UserEntityFacade getUserEntityFacade() {
        return userEntityFacade;
    }

    public void setUserEntityFacade(UserEntityFacade userEntityFacade) {
        this.userEntityFacade = userEntityFacade;
    }

    public UserAddressEntityFacade getUserAddressEntityFacade() {
        return userAddressEntityFacade;
    }

    public void setUserAddressEntityFacade(UserAddressEntityFacade userAddressEntityFacade) {
        this.userAddressEntityFacade = userAddressEntityFacade;
    }

    public UserDetailsEntityFacade getUserDetailsEntityFacade() {
        return userDetailsEntityFacade;
    }

    public void setUserDetailsEntityFacade(UserDetailsEntityFacade userDetailsEntityFacade) {
        this.userDetailsEntityFacade = userDetailsEntityFacade;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserAddressEntity getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddressEntity userAddress) {
        this.userAddress = userAddress;
    }

    public UserDetailsEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsEntity userDetails) {
        this.userDetails = userDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void validatePassword() {
        if(!rePassword.equals(password)) {
            //throw new ValidatorException( new FacesMessage("Password Not Matched!"));            
        }
    }
    
    public String registration() {
        try {            
            userEntity.setPassword(password);
            userDetails.setAddressID(userAddress);            
            userEntity.setUserDetailsID(userDetails);
            getUserEntityFacade().create(userEntity);            
        } 
        catch (Exception e) {
           return "registration?faces-redirect=true";
        }
        return "home?faces-redirect=true";
    }
    
    public String loginRedirect() {
        return "login?faces-redirect=true";
    }
}