package com.laptrinhjavaweb.dto;

import java.io.Serializable;

public class JSONFileUpload implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3518018120515946312L;
	
	private String path;
	

	public JSONFileUpload() {
		super();
	}

	public JSONFileUpload(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
