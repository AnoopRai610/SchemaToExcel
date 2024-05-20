package com.accenture.wsdl.utility;

public class OdataDetails {

	private String id;
	private String name;
	private String apiDetails;
	private String service;

	public OdataDetails(String id, String name, String apiDetails, String service) {
		super();
		this.id = id;
		this.name = name;
		this.apiDetails = apiDetails;
		this.service = service;
	}

	public String getId() {
		return id.trim();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiDetails() {
		if (apiDetails.startsWith("\"") && apiDetails.endsWith("\""))
			return apiDetails.substring(1, apiDetails.length() - 1);
		return apiDetails;
	}

	public void setApiDetails(String apiDetails) {
		this.apiDetails = apiDetails;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "OdataDetails [id=" + id + ", name=" + name + ", service=" + service + "]";
	}
}
