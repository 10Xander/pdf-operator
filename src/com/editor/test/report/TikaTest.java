package com.editor.test.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class TikaTest {

	public static void main(String[] args) throws IOException, SAXException, TikaException {
		File file = new File("E:\\oneDrive file\\OneDrive\\桌面\\shixiaodong\\61-cv-english-97-2003.doc"); // 指定要解析的文件路径
		Tika tika = new Tika();
		String string = tika.parseToString(file);
		System.out.println(string);
		
//		Parser parser = new PDFParser(); // 创建 TXT 解析器实例
//		ContentHandler handler = new BodyContentHandler(-1); // 创建 BodyContentHandler 实例
//		Metadata metadata = new Metadata(); // 创建 Metadata 实例
//		ParseContext context = new ParseContext(); // 创建 ParseContext 实例
//
//		try (InputStream stream = new FileInputStream(file)) {
//			parser.parse(stream, handler, metadata, context); // 解析文件
//		}
//
//		String content = handler.toString(); // 获取解析后的文本内容
//		List<String> words = Arrays.asList(content.split("\\s+")); // 将文本内容拆分为单词列表
//
//		// 获取每个单词在原文件中的位置坐标
//		for (String word : words) {
//			int start = content.indexOf(word);
//			int end = start + word.length();
//			System.out.println(word + " (" + start + "," + end + ")");
//		}
	}
}
