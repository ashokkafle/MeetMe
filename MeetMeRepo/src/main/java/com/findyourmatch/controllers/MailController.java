/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.facade.MailFacade;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;

/**
 *
 * @author ASHOK
 */
@Named("mail")
@RequestScoped
public class MailController {

    /**
     * Creates a new instance of MailController
     */
    public MailController() {
    }

    @EJB
    private MailFacade mailSatelessBean;

    private String to = "meetme7778@gmail.com";
    private String from = "meetme7778@gmail.com";
    private String address = "";
    private String email = "";
    private String phone = "";
    private String name = "";
    private String company;
    private String sub;
    private String message;
    private String uname = "meetme7778@gmail.com";
    private String pass = "Meetmenow";
    private String detail;

    //  public String detail= "Name :"+name +"Email:"+email+ "Phone :" +phone +"Message:"+message;
    public String sendmail() {
        detail = "Company:" + company + "<BR>" + "Name :" + name + "<BR/>" + "Email:" + email + "<BR/>" + "Phone :" + phone + "<BR/>" + "Message:" + message;
        try {
            mailSatelessBean.sendEmail(from, uname, pass, to, sub, detail);
        } catch (MessagingException ex) {
            Logger.getLogger(MailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MailFacade getMailSatelessBean() {
        return mailSatelessBean;
    }

    public void setMailSatelessBean(MailFacade mailSatelessBean) {
        this.mailSatelessBean = mailSatelessBean;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
