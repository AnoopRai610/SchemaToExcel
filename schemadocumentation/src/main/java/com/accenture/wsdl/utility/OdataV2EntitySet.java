package com.accenture.wsdl.utility;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OdataV2EntitySet {

	private String name;
	private String namespace;
	private boolean C = true;
	private boolean R = true;
	private boolean U = true;
	private boolean D = true;
	private OdataV2EntityType entityType;

	private EdmEntitySet V;

	public OdataV2EntitySet(EdmEntitySet V, String namespace, Document xmlDoc) throws Exception {
		this.V = V;
		this.name = V.getName();
		this.namespace = namespace;
		Element entitySetNode = setEntitySetElement(xmlDoc);

		setC(getBoolean(entitySetNode.getAttribute("sap:creatable")));
		setU(getBoolean(entitySetNode.getAttribute("sap:updatable")));
		setD(getBoolean(entitySetNode.getAttribute("sap:deletable")));

	}

	private boolean getBoolean(String attribute) {
		if (attribute != null && !attribute.isEmpty())
			return Boolean.parseBoolean(attribute);
		return true;
	}

	private Element setEntitySetElement(Document xmlDoc) throws Exception {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("//EntitySet[@Name=\"" + name + "\"]");
		NodeList nl = (NodeList) expr.evaluate(xmlDoc, XPathConstants.NODESET);
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n.getNodeType() == Element.ELEMENT_NODE)
				return (Element) n;
		}
		return null;
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

	public OdataV2EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(OdataV2EntityType entityType) {
		this.entityType = entityType;
	}

	public EdmEntitySet getV() {
		return V;
	}

	public void setV(EdmEntitySet v) {
		V = v;
	}

	public boolean isC() {
		return C;
	}

	public void setC(boolean c) {
		C = c;
	}

	public boolean isR() {
		return R;
	}

	public void setR(boolean r) {
		R = r;
	}

	public boolean isU() {
		return U;
	}

	public void setU(boolean u) {
		U = u;
	}

	public boolean isD() {
		return D;
	}

	public void setD(boolean d) {
		D = d;
	}

	public String getCRUD() {
		StringBuilder sb = new StringBuilder();
		if (isC())
			sb.append("C");
		if (isR())
			sb.append("R");
		if (isU())
			sb.append("U");
		if (isD())
			sb.append("D");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "OdataV2EntitySet [name=" + name + ", namespace=" + namespace + ", entityType=" + entityType + ", V=" + V
				+ "]";
	}

}
