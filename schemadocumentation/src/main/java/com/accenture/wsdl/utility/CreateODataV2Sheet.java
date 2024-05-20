package com.accenture.wsdl.utility;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.olingo.odata2.api.edm.EdmAssociationEnd;
import org.apache.olingo.odata2.api.edm.EdmAssociationSetEnd;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.BorderExtent;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.odata.utility.XSDData;
import com.accenture.utility.ColorCombo;

public class CreateODataV2Sheet {

	private XSSFWorkbook wb;
	private int rowIndex;
	private int width = 0;
	private List<ColorCombo> colorList;
	private OdataV2Container odataV2Container;

	public CreateODataV2Sheet(XSSFWorkbook wb, int rowIndex, OdataV2Container odataV2Container) {
		this.wb = wb;
		this.rowIndex = rowIndex;
		this.odataV2Container = odataV2Container;
		IndexedColorMap indexedColors = wb.getStylesSource().getIndexedColors();
		this.colorList = new ArrayList<>();
		colorList.add(new ColorCombo(new XSSFColor(new Color(153, 51, 102), indexedColors),
				new XSSFColor(new Color(255, 255, 255), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(255, 204, 153), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(255, 153, 0), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(255, 255, 153), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(255, 204, 102), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(234, 253, 119), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(204, 153, 0), indexedColors),
				new XSSFColor(new Color(0, 0, 0), indexedColors)));
		colorList.add(new ColorCombo(new XSSFColor(new Color(153, 204, 255), indexedColors),
				new XSSFColor(new Color(31, 73, 125), indexedColors)));
	}

	public CreateODataV2Sheet(XSSFWorkbook wb, int rowIndex, List<ColorCombo> colorList) {
		this.wb = wb;
		this.rowIndex = rowIndex;
		this.colorList = colorList;
	}

	public void createEntitySetSheet(OdataV2EntitySet edmEntitySet) {
		int initialRowIndex = rowIndex;
		CellStyle cellStyle = getStyle(true,
				new ColorCombo(wb.getStylesSource().getIndexedColors(), new Color(255, 255, 255)), true);

		Sheet sheet = wb.createSheet(WorkbookUtil.createSafeSheetName(edmEntitySet.getName()));

		Row row = sheet.createRow(rowIndex);
		row.setHeightInPoints((4 * sheet.getDefaultRowHeightInPoints()));
		OdataV2EntityType et = edmEntitySet.getEntityType();
		CellRangeAddress cellRangeAddress = new CellRangeAddress(3, 3, 0, et.getDepth());
		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(cellRangeAddress, BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
		sheet.addMergedRegion(cellRangeAddress);
		pt.applyBorders(sheet);

		CellUtil.createCell(row, 0, "ID and Tag Name", cellStyle);

		for (int i = 0; i <= et.getDepth(); i++) {
			sheet.setColumnWidth(i, 4 * 256);
			if (colorList.size() <= i)
				colorList.add(new ColorCombo(wb.getStylesSource().getIndexedColors(), getColor()));
		}

		CellUtil.createCell(row, et.getDepth() + 1, "Category", cellStyle);
		CellUtil.createCell(row, et.getDepth() + 2, "Occurrence", cellStyle);
		CellUtil.createCell(row, et.getDepth() + 3, "Mandatory/" + System.lineSeparator() + "Optional", cellStyle);
		CellUtil.createCell(row, et.getDepth() + 4, "SAP Label [Description]", cellStyle);
		CellUtil.createCell(row, et.getDepth() + 5, "Type", cellStyle);
		CellUtil.createCell(row, et.getDepth() + 6, "Detail", cellStyle);

		XSDData xsd = new XSDData(edmEntitySet.getName(), "EntitySet", "0..unbounded", et.getName(), "", 0);
		parseXSDDataToCells(sheet, xsd, et.getDepth());

		et.getProperties().forEach(V -> parseXSDDataToCells(sheet, V, et.getDepth()));

		et.getNavigationProperties().forEach(V -> {
			try {
				OdataV2AssociationSet asSet = odataV2Container.getAssociationSet(V.getRelationship());
				EdmAssociationEnd end = V.getEdmAssocation().getEnd(V.getToRole());
				EdmAssociationSetEnd asEnd = asSet.getAs().getEnd(V.getToRole());
				XSDData navXsd = new XSDData(V.getName(), "Navigation", end.getMultiplicity().toString(),
						asEnd.getEntitySet().getName(), V.getExtandURL(), "", "", 1);
				parseNavXSDDataToCells(sheet, navXsd, et.getDepth());
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		for (int i = 1; i < 7; i++)
			sheet.autoSizeColumn(et.getDepth() + i);

		rowIndex = initialRowIndex;
		width = 0;
	}

	private void parseXSDDataToCells(Sheet sheet, XSDData xsdData, int fullDepth) {
		rowIndex += 1;
		CellStyle cellStyle = getStyle(false, colorList.get(xsdData.getDepth()), xsdData.isElement());
		Row row = sheet.createRow(rowIndex);
		PropertyTemplate pt = new PropertyTemplate();
		if (xsdData.getDepth() != 0 && xsdData.getDepth() != 1) {
			CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, 0, xsdData.getDepth() - 1);
			sheet.addMergedRegion(cellRangeAddress);
			pt.drawBorders(cellRangeAddress, BorderStyle.THIN, BorderExtent.OUTSIDE);
		}
		if (xsdData.getDepth() != fullDepth) {
			CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, xsdData.getDepth(), fullDepth);
			sheet.addMergedRegion(cellRangeAddress);
			pt.drawBorders(cellRangeAddress, BorderStyle.THIN, BorderExtent.OUTSIDE);
		} else {
			if (xsdData.getName().length() > width) {
				width = xsdData.getName().length();
				sheet.setColumnWidth(fullDepth, (width + 5) * 256);
			}
		}
		pt.applyBorders(sheet);

		CellUtil.createCell(row, xsdData.getDepth(), xsdData.getName(), cellStyle);
		CellUtil.createCell(row, fullDepth + 1, xsdData.getCategory(), cellStyle);
		CellUtil.createCell(row, fullDepth + 2, xsdData.getOccurrence(), cellStyle);
		CellUtil.createCell(row, fullDepth + 3, (xsdData.getOccurrence().equals("1")) ? "M" : "O", cellStyle);
		CellUtil.createCell(row, fullDepth + 4,
				xsdData.getLabel() + ((xsdData.getQuickinfo().isEmpty()) ? "" : " [" + xsdData.getQuickinfo() + "]"),
				cellStyle);
		CellUtil.createCell(row, fullDepth + 5, xsdData.getType(), cellStyle);
		CellUtil.createCell(row, fullDepth + 6, xsdData.getDetail(), cellStyle);

		for (XSDData atXSDData : xsdData.getAttributes())
			parseXSDDataToCells(sheet, atXSDData, fullDepth);
		for (XSDData childXSDData : xsdData.getChildXSDData())
			parseXSDDataToCells(sheet, childXSDData, fullDepth);

	}

	private void parseNavXSDDataToCells(Sheet sheet, XSDData xsdData, int fullDepth) {
		rowIndex += 1;
		CellStyle cellStyle = getStyle(false, colorList.get(xsdData.getDepth()), xsdData.isElement());
		Row row = sheet.createRow(rowIndex);
		PropertyTemplate pt = new PropertyTemplate();
		if (xsdData.getDepth() != 0 && xsdData.getDepth() != 1) {
			CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, 0, xsdData.getDepth() - 1);
			sheet.addMergedRegion(cellRangeAddress);
			pt.drawBorders(cellRangeAddress, BorderStyle.THIN, BorderExtent.OUTSIDE);
		}
		if (xsdData.getDepth() != fullDepth) {
			CellRangeAddress cellRangeAddress = new CellRangeAddress(rowIndex, rowIndex, xsdData.getDepth(), fullDepth);
			sheet.addMergedRegion(cellRangeAddress);
			pt.drawBorders(cellRangeAddress, BorderStyle.THIN, BorderExtent.OUTSIDE);
		} else {
			if (xsdData.getName().length() > width) {
				width = xsdData.getName().length();
				sheet.setColumnWidth(fullDepth, (width + 5) * 256);
			}
		}
		pt.applyBorders(sheet);

		CellUtil.createCell(row, xsdData.getDepth(), xsdData.getName(), cellStyle);
		CellUtil.createCell(row, fullDepth + 1, xsdData.getCategory(), cellStyle);
		CellUtil.createCell(row, fullDepth + 2, xsdData.getOccurrence(), cellStyle);
		CellUtil.createCell(row, fullDepth + 3, (xsdData.getOccurrence().equals("1")) ? "M" : "O", cellStyle);
		CellUtil.createCell(row, fullDepth + 4,
				xsdData.getLabel() + ((xsdData.getQuickinfo().isEmpty()) ? "" : "[" + xsdData.getQuickinfo() + "]"),
				cellStyle);
		CellUtil.createCell(row, fullDepth + 5, xsdData.getType(), cellStyle);

		CreationHelper createHelper = wb.getCreationHelper();
		Hyperlink link = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
		link.setAddress("'" + WorkbookUtil.createSafeSheetName(xsdData.getType()) + "'!A1");
		Cell cell = row.getCell(fullDepth + 5);
		cell.setHyperlink(link);

		CellUtil.createCell(row, fullDepth + 6, xsdData.getDetail(), cellStyle);
		cellStyle.setWrapText(true);
		row.getCell(fullDepth + 6).setCellStyle(cellStyle);
	}

	private CellStyle getStyle(boolean header, ColorCombo colorCombo, boolean element) {
		XSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment((header) ? HorizontalAlignment.CENTER : HorizontalAlignment.LEFT);
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

	private Color getColor() {
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		if (r == 255 & g == 255 & b == 255)
			return getColor();
		return new Color(r, g, b);
	}

}
