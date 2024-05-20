package com.accenture.utility;

import java.awt.Color;

import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;

public class ColorCombo {

	private XSSFColor backgoundColor;
	private XSSFColor fontColor;

	public ColorCombo(XSSFColor backgoundColor, XSSFColor fontColor) {
		this.backgoundColor = backgoundColor;
		backgoundColor.getRGB();
		this.fontColor = fontColor;
	}

	public ColorCombo(IndexedColorMap indexedColors, Color backgoundColor) {
		this(new XSSFColor(backgoundColor, indexedColors),
				new XSSFColor(getInvertColor(backgoundColor, true), indexedColors));
	}

	public XSSFColor getBackgoundColor() {
		return backgoundColor;
	}

	public void setBackgoundColor(XSSFColor backgoundColor) {
		this.backgoundColor = backgoundColor;
	}

	public XSSFColor getFontColor() {
		return fontColor;
	}

	public void setFontColor(XSSFColor fontColor) {
		this.fontColor = fontColor;
	}

	private static Color getInvertColor(Color color, boolean bw) {
		if (bw) {
			return (color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() * 0.114) > 186
					? new Color(0, 0, 0)
					: new Color(255, 255, 255);
		}
		return new Color(225 - color.getRed(), 225 - color.getGreen(), 225 - color.getBlue());

	}

}
