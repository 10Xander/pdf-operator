
package com.editor.test.pdfbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.TextToPDF;

public class Demo {
	public static void main(String[] args) throws IOException {

		PDDocument document = PDDocument.load(new File("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\AntonyDeepakThomas.pdf"));

		// Create PDF text stripper
		CustomPDFTextStripper pdfStripper = new CustomPDFTextStripper();
//		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setSortByPosition(true);
		pdfStripper.setStartPage(4);
		
		// Extract text from PDF
//		pdfStripper.setLineSeparator("\n"); // 设置分段符
		pdfStripper.getText(document);
//		String text = pdfStripper.getText(document);
		String text = pdfStripper.getFullText();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		TextToPDF pdfCreator = new TextToPDF();
		PDDocument pdfDoc;
		try (StringReader reader = new StringReader(text)) {
			pdfDoc = pdfCreator.createPDFFromText(reader);
		} catch (IOException e) {
			throw new IOException(e);
		}
		pdfDoc.save(os);

		InputStream is = new ByteArrayInputStream(os.toByteArray());
//		pdfDoc.close();

		//split
		Splitter splitter = new Splitter();
		splitter.setSplitAtPage(3);
		splitter.setStartPage(1);
		splitter.setEndPage(3);
		List<PDDocument> documents = splitter.split(document);
		PDFMergerUtility utility = new PDFMergerUtility();
		for (int i = 0; i < documents.size(); i++) {
			PDDocument doc = documents.get(i);
			ByteArrayOutputStream osnei = new ByteArrayOutputStream();
			doc.save(osnei);
			InputStream isnei = new ByteArrayInputStream(osnei.toByteArray());
			utility.addSource(isnei);
//			doc.save("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\AntonyDeepakThomas" + "-" + (i + 1) + ".pdf");
//			doc.close();
//			osnei.close();
		}
		utility.addSource(is);
		is.close();
		utility.setDestinationStream(new ByteArrayOutputStream());
		utility.mergeDocuments(null);
		ByteArrayOutputStream os2 = (ByteArrayOutputStream) utility.getDestinationStream();
		InputStream is2 = new ByteArrayInputStream(os2.toByteArray());
		os2.close();
		pdfDoc.close();
		File file = new File("E:\\zzltools\\pdflib\\SRS2.pdf");
		
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			int read;
			byte[] bytes = new byte[1024];

			while ((read = is2.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		}
	}
	
}
