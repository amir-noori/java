package com.techcenter.web.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.context.FacesContext;

import com.techcenter.web.UserController;

@FacesValidator(value = "adminPrivilegeValidator")

public class AdminPrivilegeValidator implements Validator
{	
	
	private UserController userController; 
	private FacesContext context;
	
	public AdminPrivilegeValidator()
	{
		context = FacesContext.getCurrentInstance();
		userController = (UserController) context.getApplication().evaluateExpressionGet(context, "#{userController}", UserController.class);
	}
	
	public void setUserController(UserController userController)
	{
		this.userController = userController;
	}
	
	public UserController getUserController()
	{
		return this.userController;
	}
	

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {	
    	if(!userController.getUser().getIsAdmin())
    	{
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Access Denied: ", "You don not have enough priviledes.");
            throw new ValidatorException(message);
    	}
    	
    }
}


