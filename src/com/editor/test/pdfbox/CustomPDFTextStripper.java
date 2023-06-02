package com.editor.test.pdfbox;

import java.io.IOException;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class CustomPDFTextStripper extends PDFTextStripper {
	TextPosition text = null;
	StringBuilder builder = new StringBuilder();
	boolean isAppend = false;
	public CustomPDFTextStripper() throws IOException {
		super();
	}

	@Override
	protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < textPositions.size(); i++) {
//            text = textPositions.get(i);
//            if (i > 0) {
//                TextPosition previousText = textPositions.get(i - 1);
//                if (text.getFont() != previousText.getFont() || text.getFontSize()!=previousText.getFontSize()) {
//                    builder.append("\n");
//                }
//            }
//            builder.append(text.getUnicode());
//        }
//        writeString(builder.toString());
		
		for (int i = 0; i < textPositions.size(); i++) {
			text = textPositions.get(i);
			float x = text.getX();
			float y = text.getY();
			builder.append(text.getUnicode());
			if (y==108 && x>100 && !isAppend) {
				builder.append("hello hello");
				builder.append("Specification Requirements for Software (SRS)  \r\n"
						+ "From Airslope \r\n"
						+ "Vhello helloersion 2022-07-23 \r\n"
						+ "Confidential. Do not share this SRS with any other 3rd party. \r\n"
						+ " \r\n"
						+ "1. Internal Job Board Posting Lib Development Statement of Work (SOW)  \r\n"
						+ "This SOW is for the development of a Java library to post a job description on a customized \r\n"
						+ "Internal Job Board (IJB).  \r\n"
						+ "The Internal Job Board is a HTML page that contains: \r\n"
						+ " Customer Info: \r\n"
						+ "1) Customer Name (Company name) \r\n"
						+ "2) Customer Logo \r\n"
						+ "3) Customer address \r\n"
						+ "4) Customer contact email \r\n"
						+ "Job Info: \r\n"
						+ "1) Job ID \r\n"
						+ "2) Job Title \r\n"
						+ "3) Hiring Status (Open/Close) \r\n"
						+ "4) Post Date \r\n"
						+ "5) Job Detail (URL) \r\n"
						+ " \r\n"
						+ "Lib Inputs: \r\n"
						+ "1) If the Internal Job Board is first time use, an IJB template will be given together with \r\n"
						+ "Customer Info and Job Info. \r\n"
						+ "2) If the Internal Job Board is update use, an IJB will be given together with Job Info. \r\n"
						+ " \r\n"
						+ "Lib Output: \r\n"
						+ "Output updated IJB with error status if any. \r\n"
						+ " \r\n"
						+ "Core Logic: \r\n"
						+ "\r\n"
						+ "");
				isAppend =true;
			}else if (!isAppend && y>108) {
				builder.append("hello hello");
				builder.append("Specification Requirements for Software (SRS)  \r\n"
						+ "From Airslope \r\n"
						+ "Vhello helloersion 2022-07-23 \r\n"
						+ "Confidential. Do not share this SRS with any other 3rd party. \r\n"
						+ " \r\n"
						+ "1. Internal Job Board Posting Lib Development Statement of Work (SOW)  \r\n"
						+ "This SOW is for the development of a Java library to post a job description on a customized \r\n"
						+ "Internal Job Board (IJB).  \r\n"
						+ "The Internal Job Board is a HTML page that contains: \r\n"
						+ " Customer Info: \r\n"
						+ "1) Customer Name (Company name) \r\n"
						+ "2) Customer Logo \r\n"
						+ "3) Customer address \r\n"
						+ "4) Customer contact email \r\n"
						+ "Job Info: \r\n"
						+ "1) Job ID \r\n"
						+ "2) Job Title \r\n"
						+ "3) Hiring Status (Open/Close) \r\n"
						+ "4) Post Date \r\n"
						+ "5) Job Detail (URL) \r\n"
						+ " \r\n"
						+ "Lib Inputs: \r\n"
						+ "1) If the Internal Job Board is first time use, an IJB template will be given together with \r\n"
						+ "Customer Info and Job Info. \r\n"
						+ "2) If the Internal Job Board is update use, an IJB will be given together with Job Info. \r\n"
						+ " \r\n"
						+ "Lib Output: \r\n"
						+ "Output updated IJB with error status if any. \r\n"
						+ " \r\n"
						+ "Core Logic: \r\n"
						+ "\r\n"
						+ "");
				isAppend =true;
			}
		}
//		builder.append(string);
		builder.append("\r\n");
	}

	public String getFullText() {
		return builder.toString();
	}
}
