
package com.accenture.wsdl.utility;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.edm.Edm;
import org.apache.olingo.odata2.api.edm.EdmEntityContainer;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import com.accenture.utility.ColorCombo;

public class ODataV2MetadataToExcel {

	public static final String HTTP_METHOD_PUT = "PUT";
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_GET = "GET";

	public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HTTP_HEADER_ACCEPT = "Accept";

	public static final String APPLICATION_JSON = "application/json";
	public static final String APPLICATION_XML = "application/xml";
	public static final String APPLICATION_ATOM_XML = "application/atom+xml";
	public static final String APPLICATION_FORM = "application/x-www-form-urlencoded";
	public static final String METADATA = "$metadata";
	public static final String INDEX = "/index.jsp";
	public static final String SEPARATOR = "/";

	public static final boolean PRINT_RAW_CONTENT = true;
	private static final boolean debug = false;

	private Map<String, List<String>> header;
	private Document xmlDoc;

	private XSSFWorkbook wb;
	private OdataDetails odataDetails;

	public ODataV2MetadataToExcel(String serviceUrl, String out, OdataDetails odataDetails) throws Exception {
		this(serviceUrl, new File(out), odataDetails);
	}

	public ODataV2MetadataToExcel(String serviceUrl, File out, OdataDetails odataDetails) throws Exception {
		out.createNewFile();
		this.odataDetails = odataDetails;
		oDataMetadataRead(serviceUrl, new FileOutputStream(out));
	}

	public ODataV2MetadataToExcel(String serviceUrl, OutputStream out, OdataDetails odataDetails) throws Exception {
		this.odataDetails = odataDetails;
		oDataMetadataRead(serviceUrl, out);
	}

	private void oDataMetadataRead(String serviceUrl, OutputStream out) throws Exception {

		Edm edm = getEDM(serviceUrl, true);

		EdmEntityContainer edmDContainer = edm.getDefaultEntityContainer();

		OdataV2Container odataV2Container = new OdataV2Container(edmDContainer.getName(), edmDContainer.getNamespace(),
				edmDContainer.isDefaultEntityContainer());

		List<OdataV2EntitySet> entitySets = odataV2Container.getEntitySets();
		edmDContainer.getEntitySets().forEach(V -> {
			try {
				OdataV2EntitySet entitySet = new OdataV2EntitySet(V, edmDContainer.getNamespace(), xmlDoc);
				OdataV2EntityType entityType = new OdataV2EntityType(V.getEntityType(), xmlDoc, V.getName());
				entityType.setNavigationProperties(edm);
				entitySet.setEntityType(entityType);
				entitySets.add(entitySet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		List<OdataV2AssociationSet> associationSets = odataV2Container.getAssociationSets();
		edmDContainer.getAssociationSets().forEach(V -> {
			try {
				OdataV2AssociationSet associationSet = new OdataV2AssociationSet(V);
				associationSets.add(associationSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		wb = new XSSFWorkbook();
		POIXMLProperties poiProps = wb.getProperties();

		CreateODataV2Sheet sheet = new CreateODataV2Sheet(wb, 3, odataV2Container);

		poiProps.getCoreProperties().setCreator(System.getProperty("user.name") + "@accenture.com");
		poiProps.getCoreProperties()
				.setTitle("oData Metadata for " + odataDetails.getService() + ":" + odataDetails.getService());
		poiProps.getCoreProperties().setSubjectProperty("This is an auto generated Excel.");
		poiProps.getCoreProperties().setDescription("This is auto generated Excel for oData Service");
		poiProps.getCoreProperties().setCategory("oData Schema");
		poiProps.getExtendedProperties().setCompany(System.getenv().get("USERDNSDOMAIN"));

		Sheet apidetailSheet = wb.createSheet("API Detail");
		CellStyle cellStyle = getStyle(false,
				new ColorCombo(wb.getStylesSource().getIndexedColors(), new Color(255, 255, 255)), true);

		CellStyle cellStyle2 = getStyle(false,
				new ColorCombo(wb.getStylesSource().getIndexedColors(), new Color(255, 255, 255)), false);

		CellStyle cellStyle3 = getStyle(true,
				new ColorCombo(wb.getStylesSource().getIndexedColors(), new Color(180, 198, 231)), true);

		Row row = apidetailSheet.createRow(1);
		CellUtil.createCell(row, 0, odataDetails.getId().trim(), cellStyle);
		CellUtil.createCell(row, 1, odataDetails.getName(), cellStyle);
		row = apidetailSheet.createRow(2);
		CellUtil.createCell(row, 0, "oData Service", cellStyle);
		CellUtil.createCell(row, 1, odataDetails.getService(), cellStyle2);
		Row row2 = apidetailSheet.createRow(3);
		cellStyle2.setWrapText(true);
		row2.setHeightInPoints((5 * apidetailSheet.getDefaultRowHeightInPoints()));
		CellUtil.createCell(row2, 0, "API Links", cellStyle);
		CellUtil.createCell(row2, 1, odataDetails.getApiDetails(), cellStyle2);

		cellStyle2.setWrapText(false);

		row = apidetailSheet.createRow(6);
		CellUtil.createCell(row, 0, "Entity Set", cellStyle3);
		CellUtil.createCell(row, 1, "Entity Type", cellStyle3);
		CellUtil.createCell(row, 2, "Detail", cellStyle3);
		CellUtil.createCell(row, 3, "CRUD Support", cellStyle3);

		int ind = 7;
		for (OdataV2EntitySet e : entitySets) {
			row = apidetailSheet.createRow(ind);
			CellUtil.createCell(row, 0, e.getName(), cellStyle);
			CellUtil.createCell(row, 1, e.getEntityType().getName(), cellStyle2);

			CreationHelper createHelper = wb.getCreationHelper();
			Hyperlink link = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
			link.setAddress("'" + WorkbookUtil.createSafeSheetName(e.getName()) + "'!A1");
			Cell cell = row.getCell(1);
			cell.setHyperlink(link);

			CellUtil.createCell(row, 2, e.getEntityType().getLabel(), cellStyle2);
			CellUtil.createCell(row, 3, e.getCRUD(), cellStyle2);

			ind++;
		}

		for (int i = 0; i < 7; i++)
			apidetailSheet.autoSizeColumn(i);

		entitySets.forEach(V -> {
			sheet.createEntitySetSheet(V);
		});

		try {
			wb.write(out);
		} finally {
			wb.close();
			out.close();
		}

	}

	private Edm getEDM(String serviceUrl, boolean xmlDocument) throws Exception {
		InputStream content = null;
		if(serviceUrl.startsWith("http"))
			content = execute(serviceUrl + SEPARATOR + METADATA, APPLICATION_XML, HTTP_METHOD_GET, xmlDocument);
		else
			content = setDocument(new FileInputStream(serviceUrl));
		return EntityProvider.readMetadata(content, false);

	}

	private InputStream execute(String relativeUri, String contentType, String httpMethod, boolean xmlDocument)
			throws Exception {
		HttpURLConnection connection = initializeConnection(relativeUri, contentType, httpMethod);

		connection.connect();
		checkStatus(connection);

		InputStream content = connection.getInputStream();
		header = connection.getHeaderFields();

		if (connection.getHeaderField("content-encoding").contains("gzip"))
			content = unGunzipFile(content);
		if (xmlDocument)
			content = setDocument(content);

		if (debug)
			content = logRawContent(httpMethod + " request on uri '" + relativeUri + "' with content:\n  ", content,
					"\n");
		return content;
	}

	@SuppressWarnings("unused")
	private HttpURLConnection connect(String relativeUri, String contentType, String httpMethod) throws IOException {
		HttpURLConnection connection = initializeConnection(relativeUri, contentType, httpMethod);

		connection.connect();
		checkStatus(connection);

		return connection;
	}

	private HttpURLConnection initializeConnection(String absolutUri, String contentType, String httpMethod)
			throws MalformedURLException, IOException {
		URL url = new URL(absolutUri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod(httpMethod);
		connection.setRequestProperty(HTTP_HEADER_ACCEPT, contentType);
		connection.setRequestProperty("apikey", "AQQYOdKmDnxEeyj7v8ALiBjceYGRaxtR");
		if (HTTP_METHOD_POST.equals(httpMethod) || HTTP_METHOD_PUT.equals(httpMethod)) {
			connection.setDoOutput(true);
			connection.setRequestProperty(HTTP_HEADER_CONTENT_TYPE, contentType);
		}

		return connection;
	}

	private InputStream logRawContent(String prefix, InputStream content, String postfix) throws IOException {
		if (PRINT_RAW_CONTENT) {
			byte[] buffer = streamToArray(content);
			print(prefix + new String(buffer) + postfix);
			return new ByteArrayInputStream(buffer);
		}
		return content;
	}

	private byte[] streamToArray(InputStream stream) throws IOException {
		byte[] result = new byte[0];
		byte[] tmp = new byte[8192];
		int readCount = stream.read(tmp);
		while (readCount >= 0) {
			byte[] innerTmp = new byte[result.length + readCount];
			System.arraycopy(result, 0, innerTmp, 0, result.length);
			System.arraycopy(tmp, 0, innerTmp, result.length, readCount);
			result = innerTmp;
			readCount = stream.read(tmp);
		}
		stream.close();
		return result;
	}

	private InputStream setDocument(InputStream content) throws Exception {
		byte[] buf = streamToArray(content);
		xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(buf));
		return new ByteArrayInputStream(buf);
	}

	private HttpStatusCodes checkStatus(HttpURLConnection connection) throws IOException {
		HttpStatusCodes httpStatusCode = HttpStatusCodes.fromStatusCode(connection.getResponseCode());
		if (400 <= httpStatusCode.getStatusCode() && httpStatusCode.getStatusCode() <= 599) {
			throw new RuntimeException("Http Connection failed with status " + httpStatusCode.getStatusCode() + " "
					+ httpStatusCode.toString());
		}
		return httpStatusCode;
	}

	private CellStyle getStyle(boolean header, ColorCombo colorCombo, boolean element) {
		XSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.LEFT);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderTop((header) ? BorderStyle.MEDIUM : BorderStyle.THIN);
		cellStyle.setBorderBottom((header) ? BorderStyle.MEDIUM : BorderStyle.THIN);
		cellStyle.setBorderLeft((header) ? BorderStyle.MEDIUM : BorderStyle.THIN);
		cellStyle.setBorderRight((header) ? BorderStyle.MEDIUM : BorderStyle.THIN);
		cellStyle.setFillForegroundColor(colorCombo.getBackgoundColor());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		font.setColor(colorCombo.getFontColor());
		if (element)
			font.setBold(true);

		cellStyle.setFont(font);

		return cellStyle;
	}

	private static void print(String content) {
		System.out.println(content);
	}

	private InputStream unGunzipFile(InputStream io) throws Exception {
		return new GZIPInputStream(io);

	}

	public Map<String, List<String>> getHeader() {
		return header;
	}

	public void setHeader(Map<String, List<String>> header) {
		this.header = header;
	}

	public Document getXmlDoc() {
		return xmlDoc;
	}

	public void setXmlDoc(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}
}
