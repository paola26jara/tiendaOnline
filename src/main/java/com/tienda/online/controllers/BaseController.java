package com.tienda.online.controllers;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tienda.online.models.dto.response.ErrosReponse;

public class BaseController {

	 final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	
	
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	   @ExceptionHandler(NoSuchElementException.class)
		public ErrosReponse return404(NoSuchElementException ex) {  
			   return new ErrosReponse(ex.getMessage(),
					   HttpStatus.NOT_FOUND.value());
		   }
	   
	   @ResponseStatus(HttpStatus.CONFLICT)
	   @ExceptionHandler(DataIntegrityViolationException.class)
		public ErrosReponse return409(DataIntegrityViolationException ex) {  
			   return new ErrosReponse(ex.getMessage(),
					   HttpStatus.CONFLICT.value());
		   }
	   
}
