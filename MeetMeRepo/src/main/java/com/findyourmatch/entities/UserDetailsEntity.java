/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ASHOK
 */
@Entity
@Table(name = "user_detail")
public class UserDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "first_name")
    @NotNull
    private String fname;
    
    @Column(name = "last_name")
    @NotNull
    private String lname;
    
    @Column(name = "image_url")
    private String profPic;
    
    @Column(name = "sex")
    private char sex;
    
    @Column(name = "birth_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "height")
    private String height;
    
    @Column(name = "looking_for")
    private String lookingFor;
    
    @Column(name = "education")
    private String education;
    
    @Column(name = "religion")
    private String religion;
    
    @Column(name = "interested_in")
    private String interested;
    
    @Column(name = "occupation")
    private String occupation;
    
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")    
    private UserAddressEntity addressID;
    
    @Transient
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProfPic() {
        return profPic;
    }

    public void setProfPic(String profPic) {
        this.profPic = profPic;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public UserAddressEntity getAddressID() {
        return addressID;
    }

    public void setAddressID(UserAddressEntity addressID) {
        this.addressID = addressID;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetailsEntity)) {
            return false;
        }
        UserDetailsEntity other = (UserDetailsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.findyourmatch.enties.UserDetalisEntity[ id=" + id + " ]";
    }
    
}
