/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.enties.UserAddressEntity;
import com.findyourmatch.enties.UserDetalisEntity;
import com.findyourmatch.enties.UserEntity;
import com.findyourmatch.facade.UserAddressEntityFacade;
import com.findyourmatch.facade.UserDetalisEntityFacade;
import com.findyourmatch.facade.UserEntityFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
    private UserDetalisEntityFacade userDetailsEntityFacade;
    
    private UserEntity userEntity;
    private UserAddressEntity userAddress;
    private UserDetalisEntity userDetails;
    
    private String password;
    private String rePassword;
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationController() {
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

    public UserDetalisEntityFacade getUserDetailsEntityFacade() {
        return userDetailsEntityFacade;
    }

    public void setUserDetailsEntityFacade(UserDetalisEntityFacade userDetailsEntityFacade) {
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

    public UserDetalisEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetalisEntity userDetails) {
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
            new FacesMessage("Name cannot contain underscores");
        }
    }
    
    public String registration() {
        return "home";
    }
    
    public String loginRedirect() {
        return "login";
    }
}