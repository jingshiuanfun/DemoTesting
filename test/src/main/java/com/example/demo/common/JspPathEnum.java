package com.example.demo.common;

public enum JspPathEnum {

	DEMO_TEST("test/view"),
	
	;
	
	private String jspPath;
	
	private JspPathEnum(String jspPath) {
		this.jspPath = jspPath;
	}

	public String getJspPath() {
		return jspPath;
	}
	
	
}
