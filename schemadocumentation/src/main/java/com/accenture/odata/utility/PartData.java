package com.accenture.odata.utility;

public class PartData {

	private String name;
	private String element;
	private int depth;

	private XSDData elementData;

	public PartData(String name, String element) {
		super();
		this.name = name;
		this.element = element;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public XSDData getElementData() {
		return elementData;
	}

	public void setElementData(XSDData elementData) {
		this.elementData = elementData;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
