import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import com.wizdepot.digieditor.model.Field;
import com.wizdepot.digieditor.pdflib.EditorUtil;

public class mergePdftest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("E:\\zzltools\\pdflib\\BaseFile2.pdf");
		File outFile = new File("E:\\zzltools\\pdflib\\BaseFile2.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page = document.getPage(5);

		
		PDDocumentInformation information = document.getDocumentInformation();
		String author = information.getAuthor();
		String isHeader = information.getCustomMetadataValue("header");
		String maigin = information.getCustomMetadataValue("maigin");
		String isFooter = information.getCustomMetadataValue("isFooter");
		System.out.println("author: "+author);
		System.out.println("isHeader: "+isHeader);
		System.out.println("maigin: "+maigin);
		System.out.println("isFooter: "+isFooter);
		
//		information.setAuthor("WizDoc");
//		information.setCustomMetadataValue("header", "true");
//		information.setCustomMetadataValue("maigin", "72F");
//		document.setDocumentInformation(information);
		
//		PDPageContentStream contentStream = new PDPageContentStream(document, page);
//		contentStream.beginText();
//		PDFont font =  PDType1Font.TIMES_ROMAN;
//		contentStream.setFont(font, 12);
//
//		
//		contentStream.newLineAtOffset(100, 700);
//		contentStream.showText("First line of text");
//		contentStream.addComment("133");
//		contentStream.endText();
//
//		contentStream.close();
//		document.save(outFile);
//		document.close();

//		PDFTextStripper stripper = new PDFTextStripper() {
//			@Override
//			protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
//				System.out.println(text);
//				for (TextPosition textPosition : textPositions) {
//					PDFont font = textPosition.getFont();
//					String fontFamily = font.getFontDescriptor().getFontName();
//					System.out.println("kk: "+fontFamily);
//					super.writeString(text, textPositions);
//				}
//			}
//		};
//		stripper.setStartPage(6);
//		stripper.setEndPage(6);
//		String text = stripper.getText(document);

		System.out.println(111);
	}

	public static boolean isBlank(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return str.matches("\\s+");
	}

}
