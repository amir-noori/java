package com.techcenter.web.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "userNameValidator")
public class UserNameValidator implements Validator 
{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String userName = String.valueOf(value);
        boolean valid = true;
        if (value == null) {
            valid = false;
        }else if(userName.isEmpty()) {
        	valid = false;
        }else if (userName.contains("@")) {
            valid = false;
        } else if (userName.contains("&")) {
            valid = false;
        } else if (userName.contains(" ")) {
            valid = false;
        }else if (userName.contains("<")) {
    		valid = false;
        } else if (userName.contains(">")) {
        	valid = false;
        }else if (userName.contains("*")) {
        	valid = false;
        }else if (userName.contains("^")) {
        	valid = false;
        }else if (userName.contains("(")) {
        	valid = false;
        }else if (userName.contains(")")) {
        	valid = false;
        }else if (userName.contains("%")) {
        	valid = false;
        }else if (userName.contains("\"")) {
        	valid = false;
        }else if (userName.contains("+")) {
        	valid = false;
        }else if (userName.contains("=")) {
        	valid = false;
        }else if (userName.contains("!")) {
        	valid = false;
        }else if (userName.contains("'")) {
        	valid = false;
        }else if (userName.contains("$")) {
        	valid = false;
        }else if (userName.contains("~")) {
        	valid = false;
        }else if (userName.contains("`")) {
        	valid = false;
        }else if (userName.contains(":")) {
        	valid = false;
        }else if (userName.contains(";")) {
        	valid = false;
        }else if (userName.contains(",")) {
        	valid = false;
        }else if (userName.contains("]")) {
        	valid = false;
        }else if (userName.contains("[")) {
        	valid = false;
        }else if (userName.contains("{")) {
        	valid = false;
        }else if (userName.contains("}")) {
        	valid = false;
        }else if (userName.contains("?")) {
        	valid = false;
        }else if (userName.contains("\\")) {
        	valid = false;
        }else if (userName.contains("/")) {
        	valid = false;
        }else if (userName.contains("-")) {
        	valid = false;
        }
        if (!valid) 
        {
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "Invalid user name: ", "no space, @, & , < , > ,...");
            throw new ValidatorException(message);
        }
    }
}
