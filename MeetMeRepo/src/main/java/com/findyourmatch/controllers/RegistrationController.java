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
import com.statless.MailSatelessBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

/**
 *
 * @author ASHOK
 */
@Named("reg")
@RequestScoped
public class RegistrationController implements Serializable {
    @EJB
    private UserEntityFacade userEntityFacade;
    @EJB
    private UserAddressEntityFacade userAddressEntityFacade;
    @EJB
    private UserDetailsEntityFacade userDetailsEntityFacade;
    
    @EJB
    private MailSatelessBean mailBean;
    private UserEntity userEntity;
    private UserAddressEntity userAddress;
    private UserDetailsEntity userDetails;
    
    private String password;
    private String rePassword;
     private String mailpass="";
    private String mailusername="";
    private String from="";
//    private String message ="Your username: "+userEntity.getUsername()+"<BR/>"+"Password:"+userEntity.getPassword();
    private String message="";
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationController() {
        userEntity = new UserEntity();
        userAddress = new UserAddressEntity();
        userDetails = new UserDetailsEntity();
        mailpass="Meetmenow";
    mailusername="meetme7778@gmail.com";
    from = "meetme7778@gmail.com";
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
            FacesMessage message = new FacesMessage("Password Not Matched!");
            FacesContext.getCurrentInstance().addMessage(null, message);
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
        
          message ="Congratulations! You are successfuly registered.<BR/>"
                     + "Your username: "+userEntity.getUsername()+"<BR/>"+"Password:"+userEntity.getPassword();
        try {
            mailBean.sendEmail(from, mailusername, mailpass, userEntity.getUsername(), "Confirmation", message);
        } catch (MessagingException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "home?faces-redirect=true";
    }
    
    public String loginRedirect() {
        return "login?faces-redirect=true";
    }
}