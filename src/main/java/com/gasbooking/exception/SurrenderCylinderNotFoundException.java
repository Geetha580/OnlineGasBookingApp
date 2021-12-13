package com.gasbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SurrenderCylinderNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7376827836189878052L;
	public SurrenderCylinderNotFoundException(String msg) {
		super(msg);
	}
}
