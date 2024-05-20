package com.accenture.wsdl.utility;

import org.apache.olingo.odata2.api.edm.EdmAssociation;
import org.apache.olingo.odata2.api.edm.EdmAssociationSet;
import org.apache.olingo.odata2.api.edm.EdmException;

public class OdataV2AssociationSet {

	private String name;
	private OdataV2End end1;
	private OdataV2End end2;
	private EdmAssociation edmAssocation;

	private EdmAssociationSet as;

	public OdataV2AssociationSet(EdmAssociationSet as) throws EdmException {
		this.as = as;
		this.name = as.getName();
		this.edmAssocation = as.getAssociation();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OdataV2End getEnd1() {
		return end1;
	}

	public void setEnd1(OdataV2End end1) {
		this.end1 = end1;
	}

	public OdataV2End getEnd2() {
		return end2;
	}

	public void setEnd2(OdataV2End end2) {
		this.end2 = end2;
	}

	public EdmAssociation getEdmAssocation() {
		return edmAssocation;
	}

	public void setEdmAssocation(EdmAssociation edmAssocation) {
		this.edmAssocation = edmAssocation;
	}

	public EdmAssociationSet getAs() {
		return as;
	}

	public void setAs(EdmAssociationSet as) {
		this.as = as;
	}

}
