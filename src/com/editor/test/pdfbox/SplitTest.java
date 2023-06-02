package com.editor.test.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitTest {

	public static void main(String[] args) throws IOException {
		Splitter splitter = new Splitter();
		PDDocument document = PDDocument
				.load(new File("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\AntonyDeepakThomas.pdf"));
		splitter.setSplitAtPage(3);
		splitter.setStartPage(1);
		splitter.setEndPage(3);
		List<PDDocument> documents = splitter.split(document);
		for (int i = 0; i < documents.size(); i++) {
			PDDocument doc = documents.get(i);
			doc.save("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\AntonyDeepakThomas" + "-" + (i + 1) + ".pdf");
			doc.close();
		}
	}

}
