package com.editor.test.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class PDFhighlightDemo extends PDFTextStripper {

	List<TextPosition> positions = new ArrayList<>();
//	int leijia = 0;
//	int kl =0;
	
	String[] criteria = null;
	
	public PDFhighlightDemo(String[] words) throws IOException {
		super();
		this.criteria = words;
	}

	public static void main(String[] args) throws IOException {
		PDDocument document = null;
		String fileName = "E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\michael.pdf";
		String[] words = {"java","rabbitmq","business","position"};
		System.out.println(11);
		try {
			document = PDDocument.load(new File(fileName));
			PDFTextStripper stripper = new PDFhighlightDemo(words);
			stripper.setSortByPosition(true);
//			stripper.setLineSeparator("\n"); 
			stripper.setStartPage(0);
			stripper.setEndPage(document.getNumberOfPages());

			Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
			stripper.writeText(document, dummy);

			File file1 = new File("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\Brendan_Herger_Resume3.pdf");
			document.save(file1);
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}


	@Override
	protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
		boolean isFound = false;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		float posXInit1 = 0, posXEnd1 = 0, posYInit1 = 0, posYEnd1 = 0, width1 = 0, height1 = 0, fontHeight1 = 0;
		String str  = string.toLowerCase();
		for (int i = 0; i < criteria.length; i++) {
			String subStr  = criteria[i].toLowerCase();
			if (str.contains(subStr)) isFound = true;
			int lastIndex = 0;
			while (lastIndex != -1) {
			    lastIndex = str.indexOf(subStr, lastIndex);
			    if (lastIndex != -1) {
			    	map.put(lastIndex, criteria[i].length());
			        lastIndex += subStr.length();
			    }
			}
		}

		if (isFound) {
			Set<Integer> keySet = map.keySet();
			for (Integer start : keySet) {
				posXInit1 = textPositions.get(start).getXDirAdj();
				posXEnd1 = textPositions.get(start+map.get(start) - 1).getXDirAdj()
						+ textPositions.get(start+map.get(start) - 1).getWidth();
				posYInit1 = textPositions.get(start).getPageHeight() - textPositions.get(start).getYDirAdj();
				posYEnd1 = textPositions.get(start).getPageHeight()
						- textPositions.get(start+map.get(start) - 1).getYDirAdj();
				width1 = textPositions.get(start).getWidthDirAdj();
				height1 = textPositions.get(start).getHeightDir();
				//
				float quadPoints[] = { posXInit1, posYEnd1 + height1 + 2, posXEnd1, posYEnd1 + height1 + 2, posXInit1,
						posYInit1 - 2, posXEnd1, posYEnd1 - 2 };

				List<PDAnnotation> annotations = document.getPage(this.getCurrentPageNo() - 1).getAnnotations();
				PDAnnotationTextMarkup highlight = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);

				PDRectangle position = new PDRectangle();
				position.setLowerLeftX(posXInit1);
				position.setLowerLeftY(posYEnd1);
				position.setUpperRightX(posXEnd1);
				position.setUpperRightY(posYEnd1 + height1);
				highlight.setRectangle(position);

				highlight.setQuadPoints(quadPoints);

				PDColor yellow = new PDColor(new float[] { 1, 1, 1 / 255F }, PDDeviceRGB.INSTANCE);
				highlight.setColor(yellow);
				annotations.add(highlight);
				
			}
			
		}
	}
	
	
//	@Override
//	protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
//		boolean isFound = false;
//	  
//		System.out.println(string);
//		//
////		int osize = positions.size();
//		int osize = leijia;
//		leijia += textPositions.size();
////		positions.addAll(textPositions);
////		int nsize = positions.size();
//		int nsize = leijia;
//		int start = 1434;
//		int end = 1438;
//		for (int i = 0; i < textPositions.size(); i++) {
//			
////			int m = osize + i;
////			if (m > start && m < end) {
////				System.out.println(textPositions.get(i).getUnicode());
////			}
//			kl++;
//			System.out.println(textPositions.get(i).getUnicode()+"----"+kl);
//			if (textPositions.get(i).getUnicode().getBytes().length>1) {
//				kl += textPositions.get(i).getUnicode().getBytes().length-1;
//			}
//		}
//		kl += 2;
//
//		float posXInit1 = 0, posXEnd1 = 0, posYInit1 = 0, posYEnd1 = 0, width1 = 0, height1 = 0, fontHeight1 = 0;
//
////        String[] criteria = {"angular", "prepared"};
//
////        for (int i = 0; i < criteria.length; i++) {
////           
////        }
////		if (string.toLowerCase().contains("Java".toLowerCase())) {
////			isFound = true;
////		}
//		isFound = true;
//		if (isFound) {
//			int count = 0;
//			for (int i = 0; i < textPositions.size(); i++) {
//				int m = osize + i;
//				if (m > start && m < end) {
//					count++;
//					posXInit1 = textPositions.get(start - osize).getXDirAdj();
//					posXEnd1 = textPositions.get(start - osize + count).getXDirAdj()
//							+ textPositions.get(start - osize + count).getWidth();
//					posYInit1 = textPositions.get(start - osize).getPageHeight()
//							- textPositions.get(start - osize).getYDirAdj();
//					posYEnd1 = textPositions.get(start - osize).getPageHeight()
//							- textPositions.get(start - osize + count).getYDirAdj();
//					width1 = textPositions.get(start - osize).getWidthDirAdj();
//					height1 = textPositions.get(start - osize).getHeightDir();
//				}
//				
////				posXInit1 = textPositions.get(0).getXDirAdj();
////				posXEnd1 = textPositions.get(textPositions.size() - 1).getXDirAdj()
////						+ textPositions.get(textPositions.size() - 1).getWidth();
////				posYInit1 = textPositions.get(0).getPageHeight() - textPositions.get(0).getYDirAdj();
////				posYEnd1 = textPositions.get(0).getPageHeight()
////						- textPositions.get(textPositions.size() - 1).getYDirAdj();
////				width1 = textPositions.get(0).getWidthDirAdj();
////				height1 = textPositions.get(0).getHeightDir();
//
//			}
//
//			float quadPoints[] = { posXInit1, posYEnd1 + height1 + 2, posXEnd1, posYEnd1 + height1 + 2, posXInit1,
//					posYInit1 - 2, posXEnd1, posYEnd1 - 2 };
//
//			List<PDAnnotation> annotations = document.getPage(this.getCurrentPageNo() - 1).getAnnotations();
//			PDAnnotationTextMarkup highlight = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.SUB_TYPE_HIGHLIGHT);
//
//			PDRectangle position = new PDRectangle();
//			position.setLowerLeftX(posXInit1);
//			position.setLowerLeftY(posYEnd1);
//			position.setUpperRightX(posXEnd1);
//			position.setUpperRightY(posYEnd1 + height1);
//
//			highlight.setRectangle(position);
//
//			// quadPoints is array of x,y coordinates in Z-like order (top-left, top-right,
//			// bottom-left,bottom-right)
//			// of the area to be highlighted
//
//			highlight.setQuadPoints(quadPoints);
//
//			PDColor yellow = new PDColor(new float[] { 1, 1, 1 / 255F }, PDDeviceRGB.INSTANCE);
//			highlight.setColor(yellow);
//			annotations.add(highlight);
//		}
//	}

}
