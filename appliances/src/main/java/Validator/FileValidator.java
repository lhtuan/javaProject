package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pojo.UploadedFile;

public class FileValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object uploadedFile, Errors errors) {
		// TODO Auto-generated method stub
		UploadedFile file = (UploadedFile) uploadedFile;  
		  
		  if (file.getFile().getSize() == 0) {  
		   errors.rejectValue("file", "uploadForm.salectFile",  
		     "Please select a file!");  
		  }  
	}

}
