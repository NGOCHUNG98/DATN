package com.laptrinhjavaweb.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.laptrinhjavaweb.dto.UserDTO;

@Component
public class PasswordValidator implements Validator {
	
	public boolean supports(Class<?> paramClass) {
        return UserDTO.class.equals(paramClass);
    }
 
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", "valid.passwordConf");
        UserDTO password = (UserDTO) obj;
        
    }

}
