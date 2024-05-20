package com.accenture.java.DocumentStructureDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.accenture.odata.utility.WSDLtoExcel;
import com.accenture.wsdl.utility.ODataV2MetadataToExcel;
import com.accenture.wsdl.utility.OdataDetails;

public class ExcelApp {

	public static void main(String... f) throws Exception {
		String rootUrl = "https://sandbox.api.sap.com/s4hanacloud/sap/opu/odata/sap/";
		ExcelApp e = new ExcelApp();
		e.oDataToFile("../Test/Schema\\", rootUrl);
		e.WSDL2File("../wsdl","../wsdlout",false);
		System.out.println("Done");
	}

	public void WSDL2File(String dir, String targetDir, boolean isParentPath) throws IOException {
		File dirFile = new File(dir);
		List<File> files = null;
		if (dirFile.isDirectory()) {
			FilenameFilter filter = new FilenameFilter() {
				@Override
				public boolean accept(File f, String name) {
					if (new File(f.getPath() + File.separator + name).isFile())
						return name.endsWith(".wsdl");
					return false;
				}
			};
			files = Arrays.asList(dirFile.listFiles(filter));
		} else {
			files = new ArrayList<>();
			files.add(dirFile);
		}
		files.parallelStream().forEach(f ->
			{
				System.out.println("Start processing for " + f.getName());
				try {
					new WSDLtoExcel().runWhole(f, new File(targetDir + File.separator + f.getName().replace(".wsdl", ".xlsx")),
							isParentPath);
				} catch (IOException e) {
					System.out.println("Error for " + f.getName() + e);
				}
				System.out.println("End processing for " + f.getName());
			});
	}

	public void oDataToFile(String dir, String rootUrl) throws Exception {
		InputStream io = new FileInputStream(dir + "APIFile");
		byte[] b = new byte[io.available()];
		io.read(b);
		io.close();
		String st = new String(b);

		List<OdataDetails> odataList = new ArrayList<>();

		mapdata(st, odataList);

		odataList.parallelStream().forEach(V -> {
			try {
				System.out.println("Start " + V.getService());
				new ODataV2MetadataToExcel(
						rootUrl + V.getService(),
						dir + V.getId().trim() + "_" + V.getName() + ".xlsx", V);
				System.out.println("end " + V.getService());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	private void mapdata(String st, List<OdataDetails> odataList) {
		String[] data = st.split("\\$");
		for (int i = 0; i < data.length; i++) {
			String[] d = data[i].split("\\|");
			OdataDetails details = new OdataDetails(d[0], d[1], d[2], d[3]);
			odataList.add(details);
		}

	}

}
