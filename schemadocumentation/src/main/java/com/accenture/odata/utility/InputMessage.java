package com.accenture.odata.utility;

import java.util.ArrayList;
import java.util.List;

import com.accenture.wsdl.utility.Message;

public class InputMessage implements Message {

	private String name;
	private String message;
	private List<PartData> partDatas;

	public InputMessage(String name, String message) {
		this.name = name;
		this.message = message;
		this.partDatas = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PartData> getPartDatas() {
		return partDatas;
	}

	public void setPartDatas(List<PartData> partDatas) {
		this.partDatas = partDatas;
	}

}
