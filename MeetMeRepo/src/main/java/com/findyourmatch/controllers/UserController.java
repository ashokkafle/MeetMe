/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.enties.UserEntity;
import com.findyourmatch.facade.UserEntityFacade;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author ASHOK
 */
@Named("user")
@SessionScoped
public class UserController implements Serializable {
    private String username;
    private String password;
    private UserEntity current;
    private UserEntity loggedInUser;

    @EJB
    private UserEntityFacade ejbFacade;

    /**
     * Creates a new instance of UserBean
     */
    public UserController() {
    }

    public UserEntity getCurrent() {
        return current;
    }

    public void setCurrent(UserEntity current) {
        this.current = current;
    }

    public UserEntityFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UserEntityFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserEntity loggedInUser) {
        this.loggedInUser = loggedInUser;
    }    

    public String login() {        
        List<Object> userList = ejbFacade.findByName(username, password);
        if(userList.isEmpty()) {
            return "login?faces-redirect=true";
        }
        else {
            loggedInUser = (UserEntity)userList.get(0);
            return "home?faces-redirect=true";
        }
    }
    
    public void isLoggedIn(ComponentSystemEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();        
	if (loggedInUser == null) { 
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler(); 
            nav.performNavigation("login?faces-redirect=true");
	}
    }
    
    public String logout() {
        loggedInUser = null;
        return "login?faces-redirect=true";
    }
}
