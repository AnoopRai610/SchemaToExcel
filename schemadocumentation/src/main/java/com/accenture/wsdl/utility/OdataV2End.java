package com.accenture.wsdl.utility;

public class OdataV2End {

	private String entitySet;
	private String role;

	public OdataV2End(String entitySet, String role) {
		super();
		this.entitySet = entitySet;
		this.role = role;
	}

	public String getEntitySet() {
		return entitySet;
	}

	public void setEntitySet(String entitySet) {
		this.entitySet = entitySet;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
