/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ASHOK
 */
@Named("reg")
@SessionScoped
public class RegistrationBean implements Serializable {

    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationBean() {
    }
    
    public String registration() {
        return "home";
    }
    
    public String loginRedirect() {
        return "login";
    }
}
