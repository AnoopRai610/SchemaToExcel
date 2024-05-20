package com.accenture.odata.utility;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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

import com.accenture.utility.ColorCombo;
import com.accenture.wsdl.utility.Message;

public class CreateXSDSheet {

	private XSSFWorkbook wb;
	private int rowIndex;
	private int width = 0;
	private List<ColorCombo> colorList;

	public CreateXSDSheet(XSSFWorkbook wb, int rowIndex) {
		this.wb = wb;
		this.rowIndex = rowIndex;
		IndexedColorMap indexedColors = wb.getStylesSource().getIndexedColors();
		this.colorList = new ArrayList<>();
		colorList.add(new ColorCombo(new XSSFColor(new Color(153, 204, 255), indexedColors),
				new XSSFColor(new Color(31, 73, 125), indexedColors)));
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
	}

	public CreateXSDSheet(XSSFWorkbook wb, int rowIndex, List<ColorCombo> colorList) {
		this.wb = wb;
		this.rowIndex = rowIndex;
		this.colorList = colorList;
	}

	public void createXSDSheet(Message message, boolean isXPATH) {
		System.out.println("Creation started");
		int initialRowIndex = rowIndex;
		CellStyle cellStyle = getStyle(true,
				new ColorCombo(wb.getStylesSource().getIndexedColors(), new Color(255, 255, 255)), true);
		for (PartData part : message.getPartDatas()) {

			Sheet sheet = wb.createSheet(WorkbookUtil.createSafeSheetName(part.getName()));
			int c = 0;
			Row row = sheet.createRow(rowIndex);
			row.setHeightInPoints((4 * sheet.getDefaultRowHeightInPoints()));
			if (isXPATH) {
				part.setDepth(0);
				CellUtil.createCell(row, c++, "Parent Structure", cellStyle);
			} else {
				CellRangeAddress cellRangeAddress = new CellRangeAddress(3, 3, 0, part.getDepth());
				PropertyTemplate pt = new PropertyTemplate();
				pt.drawBorders(cellRangeAddress, BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
				sheet.addMergedRegion(cellRangeAddress);
				pt.applyBorders(sheet);
				CellUtil.createCell(row, c++, "ID and Tag Name in the XML file", cellStyle);
			}

			for (int i = 0; i <= part.getDepth(); i++) {
				sheet.setColumnWidth(i, 4 * 256);
				if (colorList.size() <= i)
					colorList.add(new ColorCombo(wb.getStylesSource().getIndexedColors(), getColor()));
			}

			if (isXPATH)
				CellUtil.createCell(row, part.getDepth() + (c++), "Item Name", cellStyle);
			CellUtil.createCell(row, part.getDepth() + (c++), "Category", cellStyle);
			CellUtil.createCell(row, part.getDepth() + (c++), "Occurrence", cellStyle);
			CellUtil.createCell(row, part.getDepth() + (c++), "Type", cellStyle);
			CellUtil.createCell(row, part.getDepth() + (c++), "Detail", cellStyle);
			if (isXPATH)
				CellUtil.createCell(row, part.getDepth() + (c++), "Length", cellStyle);
			if (isXPATH)
				parseXSDDataToCells(sheet, part.getElementData(), "", part.getDepth());
			else
				parseXSDDataToCells(sheet, part.getElementData(), part.getDepth());

			for (int i = 1; i < c; i++)
				sheet.autoSizeColumn(part.getDepth() + i);

			rowIndex = initialRowIndex;
			width = 0;
			System.out.println("Creation done");
		}
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
		CellUtil.createCell(row, fullDepth + 3, xsdData.getType(), cellStyle);
		CellUtil.createCell(row, fullDepth + 4, xsdData.getDetail(), cellStyle);

		for (XSDData atXSDData : xsdData.getAttributes())
			parseXSDDataToCells(sheet, atXSDData, fullDepth);
		for (XSDData childXSDData : xsdData.getChildXSDData())
			parseXSDDataToCells(sheet, childXSDData, fullDepth);

	}

	private void parseXSDDataToCells(Sheet sheet, XSDData xsdData, String parent, int fullDepth) {
		rowIndex += 1;
		if (colorList.size() <= xsdData.getDepth())
			colorList.add(new ColorCombo(wb.getStylesSource().getIndexedColors(), getColor()));
		CellStyle cellStyle = getStyle(false, colorList.get(xsdData.getDepth()), xsdData.isElement());
		Row row = sheet.createRow(rowIndex);
		PropertyTemplate pt = new PropertyTemplate();
		if (xsdData.getName().length() > width) {
			width = xsdData.getName().length();
			sheet.setColumnWidth(fullDepth, (width + 5) * 256);
		}
		pt.applyBorders(sheet);

		CellUtil.createCell(row, fullDepth, parent, cellStyle);
		CellUtil.createCell(row, fullDepth + 1,
				(xsdData.getCategory().equalsIgnoreCase("Attribute")) ? "@" + xsdData.getName() : xsdData.getName(),
				cellStyle);
		CellUtil.createCell(row, fullDepth + 2, xsdData.getCategory(), cellStyle);
		CellUtil.createCell(row, fullDepth + 3, xsdData.getOccurrence(), cellStyle);
		CellUtil.createCell(row, fullDepth + 4, xsdData.getType(), cellStyle);

		Map<String, String> details = xsdData.getFromData();
		StringBuilder sb = new StringBuilder();
		if (details.containsKey("minLength"))
			sb.append(details.get("minLength"));
		if (details.containsKey("minLength"))
			if (sb.length() == 0)
				sb.append(details.get("maxLength"));
			else
				sb.append("-" + details.get("maxLength"));
		if (details.containsKey("length"))
			sb.append(details.get("length"));

		CellUtil.createCell(row, fullDepth + 5, sb.toString(), cellStyle);
		StringBuilder sb2 = new StringBuilder();
		details.forEach((K, V) -> {
			if (!(K.equals("minLength") || K.equals("maxLength") || K.equals("length")))
				if (sb2.length() == 0)
					sb2.append(K + "=" + V);
				else
					sb2.append(";" + K + "=" + V);

		});
		CellUtil.createCell(row, fullDepth + 6, sb2.toString(), cellStyle);

		for (XSDData atXSDData : xsdData.getAttributes())
			parseXSDDataToCells(sheet, atXSDData, parent + "/" + xsdData.getName(), 0);
		for (XSDData childXSDData : xsdData.getChildXSDData())
			parseXSDDataToCells(sheet, childXSDData,
					(parent.isEmpty()) ? xsdData.getName() : parent + "/" + xsdData.getName(), 0);

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
