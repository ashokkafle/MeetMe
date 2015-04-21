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
public class RegistrationController implements Serializable {

    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationController() {
    }
    
    public String registration() {
        return "home";
    }
    
    public String loginRedirect() {
        return "login";
    }
}
//temp data
//
//<?xml version="1.0" encoding="UTF-8"?>
//<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
//  <persistence-unit name="MeetMePU" transaction-type="JTA">
//    <jta-data-source>meetMeJNDI</jta-data-source>
//    <exclude-unlisted-classes>false</exclude-unlisted-classes>
//    <properties>
//      <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
//    </properties>
//  </persistence-unit>
//</persistence>

