package com.accenture.wsdl.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmException;

public class OdataV2Container {
	private String name;
	private String namespace;
	private boolean defaultContainer;
	private List<OdataV2EntitySet> entitySets;
	private List<OdataV2AssociationSet> associationSets;

	public OdataV2Container(String name, String namespace, boolean defaultContainer) {
		this();
		this.name = name;
		this.namespace = namespace;
		this.defaultContainer = defaultContainer;
	}

	public OdataV2Container() {
		this.entitySets = new ArrayList<>();
		this.associationSets = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public boolean isDefaultContainer() {
		return defaultContainer;
	}

	public void setDefaultContainer(boolean defaultContainer) {
		this.defaultContainer = defaultContainer;
	}

	public List<OdataV2EntitySet> getEntitySets() {
		return entitySets;
	}

	public void setEntitySets(List<OdataV2EntitySet> entitySets) {
		this.entitySets = entitySets;
	}

	public List<OdataV2AssociationSet> getAssociationSets() {
		return associationSets;
	}

	public void setAssociationSets(List<OdataV2AssociationSet> associationSets) {
		this.associationSets = associationSets;
	}
	
	public OdataV2AssociationSet getAssociationSet(String association) throws EdmException {
		for(OdataV2AssociationSet aSet : getAssociationSets()) {
			if(association.equals(aSet.getEdmAssocation().getNamespace()+"."+aSet.getEdmAssocation().getName()))
				return aSet;
		}
		return null;
	}

	@Override
	public String toString() {
		return "OdataV2Container [name=" + name + ", namespace=" + namespace + ", defaultContainer=" + defaultContainer
				+ ", entitySets=" + entitySets + ", associationSets=" + associationSets + "]";
	}

}
