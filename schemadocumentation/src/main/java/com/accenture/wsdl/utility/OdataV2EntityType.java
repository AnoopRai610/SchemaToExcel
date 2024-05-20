package com.accenture.wsdl.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.olingo.odata2.api.edm.Edm;
import org.apache.olingo.odata2.api.edm.EdmAssociation;
import org.apache.olingo.odata2.api.edm.EdmEntityType;
import org.apache.olingo.odata2.api.edm.EdmException;
import org.apache.olingo.odata2.api.edm.EdmTypeKind;
import org.apache.olingo.odata2.api.edm.EdmTyped;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.accenture.odata.utility.XSDData;

public class OdataV2EntityType {

	private String name;
	private String entitySetName;
	private String namespace;
	private String label;
	private int depth = 1;
	private List<XSDData> keyDatas;
	private List<XSDData> properties;
	private List<ODataV2NavigationProperty> navigationProperties;

	private EdmEntityType e;
	private Element entityTypeNode;

	public OdataV2EntityType(String name, String namespace) {
		this.name = name;
		this.namespace = namespace;
	}

	public OdataV2EntityType(EdmEntityType e, Document xmlDoc, String entitySetName) throws Exception {
		this(e.getName(), e.getNamespace());
		this.entitySetName = entitySetName;
		this.e = e;
		this.entityTypeNode = setEntityElement(xmlDoc);
		this.label = entityTypeNode.getAttribute("sap:label");
		setDatas();
	}

	private Element setEntityElement(Document xmlDoc) throws Exception {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("//EntityType[@Name=\"" + name + "\"]");
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

	public List<XSDData> getKeyDatas() {
		if (keyDatas == null)
			keyDatas = new ArrayList<>();
		return keyDatas;
	}

	public void setKeyDatas(List<XSDData> keyDatas) {
		this.keyDatas = keyDatas;
	}

	public List<XSDData> getProperties() {
		if (properties == null)
			properties = new ArrayList<>();
		return properties;
	}

	public void setProperties(List<XSDData> properties) {
		this.properties = properties;
	}

	public List<ODataV2NavigationProperty> getNavigationProperties() {
		if (navigationProperties == null)
			navigationProperties = new ArrayList<>();
		return navigationProperties;
	}

	public void setNavigationProperties(List<ODataV2NavigationProperty> navigationProperties) {
		this.navigationProperties = navigationProperties;
	}

	public String getLabel() {
		return label;
	}

	public EdmEntityType getE() {
		return e;
	}

	public Element getEntityTypeNode() {
		return entityTypeNode;
	}

	public void setDatas() throws EdmException {
		List<String> keyPropertyNames = e.getKeyPropertyNames();
		List<String> propertyNames = e.getPropertyNames();
		propertyNames.forEach(V -> {
			try {
				EdmTyped edmType = e.getProperty(V);
				if (edmType.getType().getKind() != EdmTypeKind.SIMPLE)
					System.out.println(V + ": Yes, its not simple");
				Element property = getElementByAttribute("Property", "Name", V);
				XSDData data = new XSDData(V, keyPropertyNames.contains(V) ? "Key" : "Property",
						edmType.getMultiplicity().toString(), edmType.getType().getName(), getPropertyDetails(property),
						property.getAttribute("sap:label"), property.getAttribute("sap:quickinfo"), 1);
				getProperties().add(data);
				if (keyPropertyNames.contains(V))
					getKeyDatas().add(data);
			} catch (EdmException ex) {
				ex.printStackTrace();
			}
		});
	}

	private String getPropertyDetails(Element property) {
		StringBuilder builder = new StringBuilder("");
		NamedNodeMap at = property.getAttributes();
		for (int i = 0; i < at.getLength(); i++) {
			Node n = at.item(i);
			if (notBelongs(n.getNodeName()))
				if (builder.length() == 0)
					builder.append(n.getNodeName() + "=" + n.getTextContent());
				else
					builder.append(";" + n.getNodeName() + "=" + n.getTextContent());
		}
		return builder.toString();
	}

	private boolean notBelongs(String attName) {
		return !Arrays.asList("Name", "Type", "Nullable", "sap:label", "sap:quickinfo").contains(attName);
	}

	private Element getElementByAttribute(String node, String attribute, String value) {
		NodeList nl = entityTypeNode.getElementsByTagName(node);
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n.getNodeType() == Element.ELEMENT_NODE) {
				Element el = (Element) n;
				if (el.getAttribute(attribute).equals(value))
					return el;
			}
		}
		return null;
	}

	public void setNavigationProperties(Edm edm) throws EdmException {
		List<String> navigationPropertyNames = e.getNavigationPropertyNames();
		navigationPropertyNames.forEach(V -> {
			try {
				Element navigation = getElementByAttribute("NavigationProperty", "Name", V);
				String ref[] = navigation.getAttribute("Relationship").split("\\.");
				EdmAssociation edmAssocation = edm.getAssociation(ref[0], ref[1]);
				ODataV2NavigationProperty dataV2NavigationProperty = new ODataV2NavigationProperty(V,
						navigation.getAttribute("Relationship"), navigation.getAttribute("FromRole"),
						navigation.getAttribute("ToRole"), getNavURL(V), edmAssocation);
				getNavigationProperties().add(dataV2NavigationProperty);
			} catch (EdmException e) {
				e.printStackTrace();
			}
		});
	}

	private String getNavURL(String name) {
		StringBuilder sb = new StringBuilder("/" + entitySetName + "(");
		boolean start = true;
		for (XSDData x : getKeyDatas())
			if (start) {
				start = false;
				sb.append(x.getName() + "={'" + x.getName() + "'}");
			} else
				sb.append("," + x.getName() + "={'" + x.getName() + "'}");
		sb.append(")/" + name);
		return sb.toString();
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "OdataV2EntityType [name=" + name + ", namespace=" + namespace + ", Label=" + label + ", keyDatas="
				+ keyDatas + ", properties=" + properties + ", navigationProperties=" + navigationProperties + ", e="
				+ e + "]";
	}

}
