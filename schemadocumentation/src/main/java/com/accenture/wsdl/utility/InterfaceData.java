package com.accenture.wsdl.utility;

import java.util.ArrayList;
import java.util.List;

import com.accenture.odata.utility.OperationData;

public class InterfaceData {

	private String name;
	private List<OperationData> operationDatas;

	public InterfaceData(String name) {
		this.name = name;
		operationDatas = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OperationData> getOperationDatas() {
		return operationDatas;
	}

	public void setOperationDatas(List<OperationData> operationDatas) {
		this.operationDatas = operationDatas;
	}

}
