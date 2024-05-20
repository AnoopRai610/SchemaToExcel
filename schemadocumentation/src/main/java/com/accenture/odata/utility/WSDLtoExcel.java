package com.accenture.odata.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WSDLtoExcel {

	public void runWhole(String io, String out, boolean isXPATH) throws IOException {
		runWhole(new FileInputStream(io), new FileOutputStream(out), isXPATH);
	}

	public void runWhole(File io, File out, boolean isXPATH) throws IOException {
		runWhole(new FileInputStream(io), new FileOutputStream(out), isXPATH);
	}

	public void runWhole(InputStream io, OutputStream out, boolean isXPATH) throws IOException {
		ReadWSDL readWSDL = new ReadWSDL(io);

		XSSFWorkbook wb = new XSSFWorkbook();
		POIXMLProperties poiProps = wb.getProperties();

		poiProps.getCoreProperties().setCreator(System.getProperty("user.name") + "@accenture.com");
		poiProps.getCoreProperties().setTitle("WSDL Defination");
		poiProps.getCoreProperties().setSubjectProperty("This is auto generated Excel.");
		poiProps.getCoreProperties().setDescription("This is auto generated Excel.");
		poiProps.getCoreProperties().setCategory("WSDL Schema");
		poiProps.getExtendedProperties().setCompany(System.getenv().get("USERDNSDOMAIN"));

		CreateXSDSheet createSheet = new CreateXSDSheet(wb, 3);
		createSheet.createXSDSheet(readWSDL.readWholeWSDL().get(0).getOperationDatas().get(0).getInputMessage(),
				isXPATH);

		try {
			wb.write(out);
		} finally {
			wb.close();
		}
	}

}
