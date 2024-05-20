package com.accenture.wsdl.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.olingo.client.api.ODataClient;
import org.apache.olingo.client.api.communication.request.retrieve.EdmMetadataRequest;
import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.core.ODataClientFactory;
import org.apache.olingo.commons.api.edm.Edm;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.core.edm.EdmProviderImpl;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class oDataV4MetadataToExcel {

	private ODataClient client;
	private Map<String, Object> header;

	public oDataV4MetadataToExcel(String serviceUrl, String out) throws FileNotFoundException, IOException {
		this(serviceUrl, new File(out));
	}

	public oDataV4MetadataToExcel(String serviceUrl, File out) throws FileNotFoundException, IOException {
		out.createNewFile();
		oDataMetadataRead(serviceUrl, new FileOutputStream(out));
	}

	public oDataV4MetadataToExcel(String serviceUrl, OutputStream out) throws IOException {
		oDataMetadataRead(serviceUrl, out);
	}

	private void oDataMetadataRead(String serviceUrl, OutputStream out) throws IOException {
		client = ODataClientFactory.getClient();

		org.apache.olingo.commons.core.edm.EdmProviderImpl edm = (EdmProviderImpl) getEDM(serviceUrl);

		header.forEach((K, V) -> System.out.println(K + ":" + V));
		System.out.println(edm);

		System.out.println();
		System.out.println();

		EdmEntityType ebmType = edm.getSchemas().get(0).getEntityContainer().getEntitySets().get(0).getEntityType();
		ebmType.getPropertyNames().forEach(E -> System.out.println(E));

		XSSFWorkbook wb = new XSSFWorkbook();
		POIXMLProperties poiProps = wb.getProperties();

		poiProps.getCoreProperties().setCreator(System.getProperty("user.name") + "@accenture.com");
		poiProps.getCoreProperties().setTitle("oData Metadata");
		poiProps.getCoreProperties().setSubjectProperty("This is auto generated Excel.");
		poiProps.getCoreProperties().setDescription("This is auto generated Excel.");
		poiProps.getCoreProperties().setCategory("WSDL Schema");
		poiProps.getExtendedProperties().setCompany(System.getenv().get("USERDNSDOMAIN"));

		//CreateXSDSheet createSheet = new CreateXSDSheet(wb, 3);
		// createSheet.createXSDSheet(readWSDL.readWholeWSDL().get(0).getOperationDatas().get(0).getInputMessage());

		try {
			wb.write(out);
		} finally {
			wb.close();
		}

	}

	private Edm getEDM(String serviceUrl) throws IOException {
		EdmMetadataRequest edmMetadataReq = getClient().getRetrieveRequestFactory().getMetadataRequest(serviceUrl);
		edmMetadataReq.addCustomHeader("apikey", "AQQYOdKmDnxEeyj7v8ALiBjceYGRaxtR");
		//System.out.println(edmMetadataReq.getXMLMetadata().getEdmVersion());
		InputStream io = edmMetadataReq.rawExecute();
		System.out.println(io.available());
		byte[] byt = new byte[io.available()];
		OutputStream out = new FileOutputStream("C:\\Users\\anoop.kumar.rai\\Desktop\\testFile_out.txt");
		out.write(byt);
		out.close();
		ODataRetrieveResponse<Edm> edmResponse = edmMetadataReq.execute();
		final Edm edm = edmResponse.getBody();
		header = new HashMap<String, Object>();
		edmResponse.getHeaderNames().forEach(K -> header.put(K, edmResponse.getHeader(K)));
		return edm;
	}

	private ODataClient getClient() {
		return client;
	}

}
