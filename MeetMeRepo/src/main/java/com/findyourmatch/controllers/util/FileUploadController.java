/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findyourmatch.controllers.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Logger;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ASHOK
 */
@Named("fileUploadController")
@SessionScoped
public class FileUploadController implements Serializable {

    private static final Logger logger = Logger.getLogger(FileUploadController.class.getName());

    private UploadedFile image;

    public void uploadFileHandle() {
        if (image != null) {
            logger.info("inside if condition");
            try {
                logger.info("inside image upload");
                File targetFolder = new File("E:\\netbeans_workspace\\MeetMeRepo\\MeetMeRepo\\src\\main\\webapp\\resources\\images\\profile\\");
                InputStream insCustomerImage = this.image.getInputstream();

                OutputStream outCustomerImage = new FileOutputStream(new File(targetFolder,
                        this.image.getFileName() + ".jpg"));

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

}
