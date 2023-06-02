package com.editor.test.pdfbox;

import java.io.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.*;
import org.apache.tika.sax.*;
import org.xml.sax.*;

public class Pdf2HtmlTest {

	public static void main(String[] args) {
        String pdfFilePath = "example.pdf";
        String htmlFilePath = "example.html";
        
        PDFParser parser = new PDFParser();
        InputStream inputStream = new FileInputStream(pdfFilePath);
        ContentHandler handler = new ToXMLContentHandler();
        Metadata metadata = new Metadata();
        parser.parse(inputStream, handler, metadata, new ParseContext());
        String xml = handler.toString();
        
        InputStream htmlStream = new ByteArrayInputStream(xml.getBytes());
        OutputStream outputStream = new FileOutputStream(htmlFilePath);
        TikaSAXTransformerFactory factory = new TikaSAXTransformerFactory();
        SAXTransformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "html");
        transformer.transform(new SAXSource(new InputSource(htmlStream)), new StreamResult(outputStream));
        
        inputStream.close();
        htmlStream.close();
        outputStream.close();
	}
}
