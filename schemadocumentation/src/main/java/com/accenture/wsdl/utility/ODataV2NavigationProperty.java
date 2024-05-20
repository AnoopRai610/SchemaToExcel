package com.accenture.wsdl.utility;

import org.apache.olingo.odata2.api.edm.EdmAssociation;

public class ODataV2NavigationProperty {

	private String name;
	private String relationship;
	private String fromRole;
	private String toRole;
	private String extandURL;
	private EdmAssociation edmAssocation;

	public ODataV2NavigationProperty(String name, String relationship, String fromRole, String toRole, String extandURL,
			EdmAssociation edmAssocation) {
		this.name = name;
		this.relationship = relationship;
		this.fromRole = fromRole;
		this.toRole = toRole;
		this.extandURL = extandURL;
		this.edmAssocation = edmAssocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getFromRole() {
		return fromRole;
	}

	public void setFromRole(String fromRole) {
		this.fromRole = fromRole;
	}

	public String getToRole() {
		return toRole;
	}

	public void setToRole(String toRole) {
		this.toRole = toRole;
	}

	public String getExtandURL() {
		return extandURL;
	}

	public void setExtandURL(String extandURL) {
		this.extandURL = extandURL;
	}

	public EdmAssociation getEdmAssocation() {
		return edmAssocation;
	}

	public void setEdmAssocation(EdmAssociation edmAssocation) {
		this.edmAssocation = edmAssocation;
	}

}
