package com.editor.test.report;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;

public class TestHighLight {
	
	private String searchTerm;
	private PDPageContentStream contentStream;
	
	public TestHighLight(String search) {
		this.searchTerm = search;
	}
	
	
	public void highlight(File inputFile, File outputFile) throws IOException {
		PDDocument document = PDDocument.load(inputFile);
		PDDocument outputDocument = new PDDocument();
		for (PDPage page : document.getPages()) {
			List<PDAnnotation> annotations = page.getAnnotations();
			for(PDAnnotation annotation : annotations) {
			    if(annotation instanceof PDAnnotationTextMarkup) {
			        PDAnnotationTextMarkup textMarkup = (PDAnnotationTextMarkup) annotation;
			        String content = textMarkup.getContents();
			        System.out.println(content);
			        if(content.contains("Java")) {
			           System.out.println("highlight");
			        }
			    }
			}

			
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		String inputFilePath = "E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\Brendan_Herger_Resume.pdf";
	    String outputFilePath = "E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\Brendan_Herger_Resume2.pdf";
		TestHighLight testHighLight = new TestHighLight("java");
		testHighLight.highlight(new File(inputFilePath), new File(outputFilePath));
		System.out.println(111);
	}
	

}
