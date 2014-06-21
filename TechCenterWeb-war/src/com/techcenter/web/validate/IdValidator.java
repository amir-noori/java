package com.techcenter.web.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "idValidator")
public class IdValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	
    	String idField = String.valueOf(value);
    	
    	if(idField.isEmpty())
    	{
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Invalid ID: ", "Please Enter an Integer.");
            throw new ValidatorException(message);
    	}
    	
    	try{
    		int id = Integer.parseInt(String.valueOf(value));
    	}
       catch(Exception e){
    	   	e.getStackTrace();
        	System.out.println("\n\n\n\nId validate\n\n\n");
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Invalid ID: ", "Please Enter an Integer.");
            throw new ValidatorException(message);
        }
    }

}
