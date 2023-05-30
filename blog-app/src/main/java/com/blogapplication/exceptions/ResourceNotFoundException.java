package com.blogapplication.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldId;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldId, long fieldValue) {
		super(String.format("%s not found with %s: %l", resourceName, fieldId, fieldValue));
		this.resourceName = resourceName;
		this.fieldId = fieldId;
		this.fieldValue = fieldValue;
	}
	
	
	

}
