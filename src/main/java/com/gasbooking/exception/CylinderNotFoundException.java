package com.gasbooking.exception;

public class CylinderNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6157006305615720019L;

	public CylinderNotFoundException( String errormessage) {
		super(errormessage);
	}
	
    public CylinderNotFoundException () {
    	 
    }
}
