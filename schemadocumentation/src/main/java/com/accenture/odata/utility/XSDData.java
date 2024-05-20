package com.accenture.odata.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XSDData {

	private String name;
	private String category;
	private String occurrence;
	private String type;
	private String detail;
	private String label;
	private String quickinfo;
	private int depth;
	private List<XSDData> attributes;
	private List<XSDData> childXSDData;

	public XSDData() {

	}

	public XSDData(String name, String category, String occurrence, String type, String detail, int depth) {
		super();
		this.name = name;
		this.category = category;
		this.occurrence = occurrence;
		this.type = type;
		this.detail = detail;
		this.depth = depth;
	}

	public XSDData(String name, String category, String occurrence, String type, String detail, String label,
			String quickinfo, int depth) {
		super();
		this.name = name;
		this.category = category;
		this.occurrence = occurrence;
		this.type = type;
		this.detail = detail;
		this.label = label;
		this.quickinfo = quickinfo;
		this.depth = depth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return ifNull(category);
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOccurrence() {
		return ifNull(occurrence);
	}

	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}

	public String getType() {
		return ifNull(type);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return ifNull(detail);
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<XSDData> getChildXSDData() {
		return childXSDData = (childXSDData == null) ? new ArrayList<>() : childXSDData;
	}

	public void setChildXSDData(List<XSDData> childXSDData) {
		this.childXSDData = childXSDData;
	}

	public String ifNull(String obj) {
		return (obj == null) ? "" : obj;
	}

	public List<XSDData> getAttributes() {
		return attributes = (attributes == null) ? new ArrayList<>() : attributes;
	}

	public void setAttributes(List<XSDData> attributes) {
		this.attributes = attributes;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isElement() {
		return this.category.equals("Element");
	}

	public String getLabel() {
		return ifNull(label);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getQuickinfo() {
		return ifNull(quickinfo);
	}

	public void setQuickinfo(String quickinfo) {
		this.quickinfo = quickinfo;
	}

	public Map<String, String> getFromData() {
		Map<String, String> details = new HashMap<>();
		System.out.println("TEST");
		if (getDetail().length() > 0)
			Arrays.stream(getDetail().split("\\;")).filter(V->!V.isEmpty()).forEach(V -> details.put(V.split("=")[0], V.split("=")[1]));
		return details;

	}

	@Override
	public String toString() {
		return name + "|" + category + "|" + occurrence + "|" + type + "|" + detail + "|" + depth + "|" + label;
	}

}
