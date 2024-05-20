package com.accenture.odata.utility;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.schema.SchemaLocalElementImpl;
import org.ow2.easywsdl.schema.api.ComplexContent;
import org.ow2.easywsdl.schema.api.ComplexType;
import org.ow2.easywsdl.schema.api.Element;
import org.ow2.easywsdl.schema.api.Schema;
import org.ow2.easywsdl.schema.api.SchemaElement;
import org.ow2.easywsdl.schema.api.SimpleContent;
import org.ow2.easywsdl.schema.api.Type;
import org.ow2.easywsdl.schema.api.XmlException;
import org.ow2.easywsdl.schema.impl.ComplexTypeImpl;
import org.ow2.easywsdl.schema.impl.ElementImpl;
import org.ow2.easywsdl.schema.impl.ExtensionImpl;
import org.ow2.easywsdl.schema.impl.SimpleTypeImpl;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Annotated;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Annotation;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Appinfo;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Attribute;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Documentation;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Facet;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.LocalSimpleType;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Pattern;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Restriction;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.SimpleType;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.TotalDigits;
import org.ow2.easywsdl.schema.org.w3._2001.xmlschema.WhiteSpace;
import org.ow2.easywsdl.wsdl.WSDLFactory;
import org.ow2.easywsdl.wsdl.api.Description;
import org.ow2.easywsdl.wsdl.api.Input;
import org.ow2.easywsdl.wsdl.api.InterfaceType;
import org.ow2.easywsdl.wsdl.api.Operation;
import org.ow2.easywsdl.wsdl.api.Output;
import org.ow2.easywsdl.wsdl.api.Part;
import org.ow2.easywsdl.wsdl.api.WSDLException;
import org.ow2.easywsdl.wsdl.api.abstractItf.AbsItfDescription.WSDLVersionConstants;
import org.ow2.easywsdl.wsdl.impl.wsdl11.DescriptionImpl;
import org.ow2.easywsdl.wsdl.impl.wsdl11.MessageImpl;
import org.xml.sax.InputSource;

import com.accenture.wsdl.utility.InterfaceData;
import com.accenture.wsdl.utility.Message;

public class ReadWSDL {

	private Description desc;
	static boolean isContent = false;

	int tabs;
	int maxTabs;

	public ReadWSDL(InputSource inputSource) {
		try {
			this.desc = WSDLFactory.newInstance().newWSDLReader().read(inputSource);
		} catch (WSDLException | MalformedURLException | URISyntaxException e) {
			System.out.println("WSDL read fail");
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public ReadWSDL(InputStream iStream) {
		this(new InputSource(iStream));
	}

	public List<InterfaceData> readWholeWSDL() {
		try {
			List<InterfaceData> interfaceDatas = new ArrayList<>();

			for (InterfaceType interfaceType : desc.getInterfaces()) {

				InterfaceData interfaceData = new InterfaceData(interfaceType.getQName().getLocalPart());

				List<OperationData> operationDatas = interfaceData.getOperationDatas();

				for (Operation operation : interfaceType.getOperations()) {
					OperationData operationData = new OperationData(operation.getQName().getLocalPart());
					Input input = operation.getInput();
					if (input != null) {
						Message inputMessage = new InputMessage(input.getName(),
								input.getMessageName().getPrefix() + ":" + input.getMessageName().getLocalPart());
						getMessageData(inputMessage, input.getMessageName());
						operationData.setInputMessage(inputMessage);
					}
					Output output = operation.getOutput();
					if (output != null) {
						Message outputMessage = new InputMessage(output.getName(),
								output.getMessageName().getPrefix() + ":" + output.getMessageName().getLocalPart());
						getMessageData(outputMessage, output.getMessageName());
						operationData.setInputMessage(outputMessage);
					}
					operationDatas.add(operationData);
				}
				interfaceDatas.add(interfaceData);
			}
			return interfaceDatas;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void getMessageData(Message message, QName messageName) throws XmlException {
		MessageImpl messageImp = null;
		if (desc.getVersion() == WSDLVersionConstants.WSDL11) {
			org.ow2.easywsdl.wsdl.impl.wsdl11.DescriptionImpl descriptionImpl = (DescriptionImpl) desc;
			messageImp = descriptionImpl.getMessage(messageName);
		}
		List<PartData> partDatas = message.getPartDatas();
		for (Part part : messageImp.getParts()) {
			tabs = maxTabs = 0;
			System.out.println(part.getPartQName());
			PartData partData = new PartData(part.getPartQName().getLocalPart(),
					part.getElement().getQName().getLocalPart());
			ElementImpl element = (ElementImpl) part.getElement();
			System.out.println(element);
			XSDData xsdData = new XSDData(element.getQName().getLocalPart(), "Element",
					Integer.toString(element.getMinOccurs()),
					element.getType().getQName().getPrefix() + element.getType().getQName().getLocalPart(), "", tabs);
			partData.setElementData(xsdData);

			Schema schema = (Schema) element.getSchema();
			type(schema, element.getType(), xsdData);
			partData.setDepth(maxTabs);
			partDatas.add(partData);
		}
	}

	public void depth(int tab) {
		if (maxTabs < tab)
			maxTabs = tab;
	}

	public void type(Schema schema, Type type, XSDData xsdData) throws XmlException {
		depth(tabs);
		if (type == null) {
			System.out.println(xsdData.toString());
			return;
		}
			if (type.getClass().toString().equals("class org.ow2.easywsdl.schema.impl.ComplexTypeImpl")) {
				ComplexType compType = (ComplexTypeImpl) type;
				
				if (compType.hasSimpleContent()) {
					SimpleContent simpleContent = compType.getSimpleContent();
					ExtensionImpl ext = (ExtensionImpl) simpleContent.getExtension();
					isContent = true;
	
					type(schema, schema.getType(ext.getModel().getBase()), xsdData);
	
					List<Annotated> listAnn = ext.getModel().getAttributeOrAttributeGroup();
					List<XSDData> attributeList = xsdData.getAttributes();
					for (Annotated a : listAnn) {
						if (a.getClass().getName().equals("org.ow2.easywsdl.schema.org.w3._2001.xmlschema.Attribute")) {
							Attribute at = (Attribute) a;
							XSDData newxsdData = new XSDData();
							newxsdData.setName(at.getName());
							newxsdData.setCategory("Attribute");
							newxsdData.setOccurrence(at.getUse().toString());
							newxsdData.setDepth(tabs + 1);
							depth(tabs + 1);
							if (at.getType() != null)
								type(schema, schema.getType(at.getType()), newxsdData);
							if (at.getSimpleType() != null) {
								LocalSimpleType simpleType = at.getSimpleType();
								simpleType(simpleType, newxsdData, false);
							}
							attributeList.add(newxsdData);
						}
					}
				}
	
				if (compType.hasComplexContent()) {
					ComplexContent complexContent = compType.getComplexContent();
					System.out.println("hasComplexContent-----------------------------" + complexContent + "--");
				}
	
				if (compType.hasChoice()) {
					System.out.println("hasChoice-----------------------------");
				}
	
				if (compType.hasAll()) {
					System.out.println("hasAll-----------------------------");
				}
	
				if (compType.getAttributes().size() > 0) {
					List<org.ow2.easywsdl.schema.api.Attribute> attributesList = compType.getAttributes();
					List<XSDData> attributeList = xsdData.getAttributes();
					for (org.ow2.easywsdl.schema.api.Attribute at : attributesList) {
						XSDData newxsdData = new XSDData();
						newxsdData.setName(at.getName());
						newxsdData.setCategory("Attribute");
						newxsdData.setOccurrence(at.getUse().toString());
						newxsdData.setDepth(tabs + 1);
						depth(tabs + 1);
						type(schema, at.getType(), newxsdData);
						attributeList.add(newxsdData);
					}
				}
	
				if (compType.hasSequence()) {
					List<Element> element = compType.getSequence().getElements();
					tabs += 1;
					for (Element C : element) {
						String occurance = Integer.toString(C.getMinOccurs());
						if (!C.getMaxOccurs().equals(occurance))
							occurance = occurance.concat(".." + C.getMaxOccurs());
						XSDData newxsdData = new XSDData();
						newxsdData.setName(C.getQName().getLocalPart());
						newxsdData.setCategory("Element");
						newxsdData.setOccurrence(occurance);
						SchemaType t = XmlBeans.getContextTypeLoader().findType(C.getQName());
						 /*if (t.getContentType() == SchemaType.ELEMENT_CONTENT ||
						            t.getContentType() == SchemaType.MIXED_CONTENT)
							 {
							  SchemaParticle topParticle = t.getContentModel();
							  System.out.println(topParticle);
							 }*/
						
						if (!(C.getType() instanceof SimpleTypeImpl) && !C.getType().toString().equals("anonymous type"))
							newxsdData.setType(C.getType().getQName().getLocalPart());
						newxsdData.setDepth(tabs);
						type(schema, C.getType(), newxsdData);
						xsdData.getChildXSDData().add(newxsdData);
					}
					tabs -= 1;
				}
			} else if (type.getClass().toString().equals("class org.ow2.easywsdl.schema.impl.SimpleTypeImpl")) {
			SimpleTypeImpl simpleType = (SimpleTypeImpl) type;

			/*Annotation annotation = simpleType.getModel().getAnnotation();

			if (annotation != null) {
				List<Object> appOrDocList = annotation.getAppinfoOrDocumentation();
				for (Object appOrDoc : appOrDocList) {
					if (appOrDoc instanceof Documentation) {
						Documentation documentation = (Documentation) appOrDoc;
						System.out.println("Lang" + "=" + documentation.getLang());
						for (Object docContent : documentation.getContent()) {
							if (docContent.getClass().getName()
									.equals("com.sun.org.apache.xerces.internal.dom.ElementNSImpl")) {
								System.out.println(docContent);
							} else if (docContent instanceof String) {
								String s = (String) docContent;
								if (!s.trim().isEmpty())
									System.out.println(s);
							}
						}
					} else if (appOrDoc instanceof Appinfo) {
						Appinfo appInfo = (Appinfo) appOrDoc;
						System.out.println(appInfo.getSource());
					}
				}
			}*/

			if (!isContent) {
				if (simpleType.getQName() != null)
					xsdData.setType(simpleType.getQName().getLocalPart());
				else
					System.out.println(type + " : " + simpleType);
			} else {
				isContent = false;
			}
			simpleType(simpleType.getModel(), xsdData, true);
		}
		return;
	}

	private static void simpleType(SimpleType simpleType, XSDData xsdData, boolean typeDecleared) {
		StringBuilder builder = new StringBuilder();
		Restriction resImpl = (Restriction) simpleType.getRestriction();
		String enumeration = "";
		if (typeDecleared)
			xsdData.setType(xsdData.getType() + "(" + resImpl.getBase().getPrefix() + ":"
					+ resImpl.getBase().getLocalPart() + ")");
		else
			xsdData.setType(resImpl.getBase().getPrefix() + ":" + resImpl.getBase().getLocalPart());
		List<Object> jaxElements = resImpl.getFacets();

		for (Object jax : jaxElements) {
			if (builder.length() != 0)
				builder.append(";");

			if (jax.getClass().getName().equals(Pattern.class.getName())) {
				Pattern pattern = (Pattern) jax;
				builder.append(Pattern.class.getSimpleName() + "=" + pattern.getValue());
			} else if (jax.getClass().getName().equals(WhiteSpace.class.getName())) {
				WhiteSpace whiteSpace = (WhiteSpace) jax;
				builder.append(WhiteSpace.class.getSimpleName() + "=" + whiteSpace.getValue());
			} else if (jax.getClass().getName().equals(TotalDigits.class.getName())) {
				TotalDigits totalDigits = (TotalDigits) jax;
				builder.append(TotalDigits.class.getSimpleName() + "=" + totalDigits.getValue());
			} else {
				@SuppressWarnings("unchecked")
				JAXBElement<Facet> jaxElement = (JAXBElement<Facet>) jax;
				if (jaxElement.getName().getLocalPart().equals("enumeration")) {
					if (enumeration.isEmpty())
						enumeration = jaxElement.getValue().getValue();
					else
						enumeration = enumeration.concat("," + jaxElement.getValue().getValue());
				} else
					builder.append(jaxElement.getName().getLocalPart() + "=" + jaxElement.getValue().getValue());
			}
		}

		if (!enumeration.isEmpty())
			builder.append(";enumeration={" + enumeration + "}");
		xsdData.setDetail(builder.toString());
	}
	public static void printPropertyInfo(SchemaProperty p)
	{
	    System.out.println("Property name=\"" + p.getName() + "\", type=\"" + p.getType().getName()
	        + "\", maxOccurs=\"" +
	        (p.getMaxOccurs() != null ? p.getMaxOccurs().toString() : "unbounded") + "\"");
	}

}
