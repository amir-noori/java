package com.techcenter.web;

import javax.faces.application.FacesMessage;  
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;   
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;  
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

  
public class FileUpload
{  	
    private UploadedFile file;  
    private String destination="D:\\FileUpload\\";
    private String userName;
    
    public FileUpload()
    {
    	
    }
    
    public UploadedFile getFile() 
    {  
        return file;  
    }  
  
    public void setUserName(String name)
    {
    	this.userName = name;
    }
    
    public String getUserName()
    {
    	return this.userName;
    }
    
    public void setFile(UploadedFile file) 
    {  
        this.file = file;  
        System.out.println("\n\n\nset1\n\n\n");
    }  
    

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  

    public void copyFile(String fileName, InputStream in) {
           try {
        	   
       			//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
       			//String userName = ec.getRequestParameterMap().get("userName");
        	   
       			System.out.println("\n\n\n"+ userName +"\n\n\n");
       			
        	    destination = destination + userName + "\\"; 
    	    	File Dir = new File(destination);
        	    if (!Dir.exists())
        	    {
        	    	try
        	    	{
        	    		Dir.mkdir();
        	    	}
        	    	catch(Exception e)
        	    	{
        	    		e.printStackTrace();
        	    	}
        	    }
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}
