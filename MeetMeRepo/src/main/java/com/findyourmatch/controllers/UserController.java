/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers;

import com.findyourmatch.entities.UserEntity;
import com.findyourmatch.facade.UserEntityFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import org.primefaces.model.UploadedFile;

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
    private List<UserEntity> listUser;
    private UserEntity currentSelectedProfile;

    @EJB
    private UserEntityFacade ejbFacade;

    /**
     * Creates a new instance of UserBean
     */
    public UserController() {
        listUser = new ArrayList<>();
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

    public UserEntity getCurrentSelectedProfile() {
        return currentSelectedProfile;
    }

    public void setCurrentSelectedProfile(UserEntity currentSelectedProfile) {
        this.currentSelectedProfile = currentSelectedProfile;
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
    
    public String editUserProfile() {
        uploadFileHandle();
        getEjbFacade().edit(loggedInUser);        
        return "profile?faces-redirect=true";
    }
    
    public String cancelUserProfileEdit() {
        return "profile?faces-redirect=true";
    }
    
    public String editProfileNavigation() {
        return "profileEdit?faces-redirect=true";
    }
    
    public String searchResult() {
        return "search?faces-redirect=true";
    }

    public List<UserEntity> getListUser() {
        if(this.listUser.isEmpty()){
            this.listUser = ejbFacade.findRecentUsers();
        }
        return listUser;
        
    }
    
    public String showDetailProfile(Long id) {
        currentSelectedProfile = new UserEntity();
        currentSelectedProfile = ejbFacade.find(id);
        return "userDetails";
    }
    
    /**File Upload Code Start**/
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    private UploadedFile image;

    private void uploadFileHandle() {
        if (image != null) {
            logger.info("inside if condition");
            try {
                logger.info("inside image upload");
                File targetFolder = new File("E:\\netbeans_workspace\\MeetMeRepo\\MeetMeRepo\\src\\main\\webapp\\resources\\images\\profile\\");
                InputStream insCustomerImage = this.image.getInputstream();

                OutputStream outCustomerImage = new FileOutputStream(new File(targetFolder,
                        this.image.getFileName()));

                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = insCustomerImage.read(bytes)) != -1) {
                    outCustomerImage.write(bytes, 0, read);
                }
                insCustomerImage.close();
                outCustomerImage.flush();
                outCustomerImage.close();

                String msg = "Succesful, " + this.image.getFileName() + "of size " + this.image.getSize() + " is uploaded.";
                logger.info(msg);
                this.loggedInUser.getUserDetailsID().setProfPic(this.image.getFileName());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }
    /**File Upload Code End**/
}
