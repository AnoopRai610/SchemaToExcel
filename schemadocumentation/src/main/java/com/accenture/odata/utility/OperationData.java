package com.accenture.odata.utility;

import com.accenture.wsdl.utility.Message;

public class OperationData {

	private String name;
	private Message inputMessage;
	private Message outputMessage;	

	public OperationData(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Message getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(Message inputMessage) {
		this.inputMessage = inputMessage;
	}

	public Message getOutputMessage() {
		return outputMessage;
	}

	public void setOutputMessage(Message outputMessage) {
		this.outputMessage = outputMessage;
	}

}
