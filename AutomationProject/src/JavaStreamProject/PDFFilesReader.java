package JavaStreamProject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class PDFFilesReader {

	public static void main(String[] args) throws IOException {
		
		//URL url=new URL("http://www.africau.edu/images/default/sample.pdf");
		//InputStream io= url.openStream();
		//BufferedInputStream fileparse= new BufferedInputStream(io);	
		//PDDocument document = PDDocument.load(fileparse);
		//System.out.println("Number of pages ::"+document.getNumberOfPages());
		//PDFTextStripper readPdf=new PDFTextStripper();
		//String text=readPdf.getText(document);
		//Assert.assertTrue(text.contains("zzzzz"), "Text Doesn't contains entered text");
		System.out.println(readPdfFilesInBrowser("http://www.africau.edu/images/default/sample.pdf"));
		System.out.println(readPdfFilesInLocalFolders("C://Personal-Docs//Capgemini-Docs//HCL-Docs//HDFCpassbook.pdf"));
		
	}

	public static String readPdfFilesInBrowser(String path) throws IOException {
		
		URL url=new URL(path);
		InputStream io= url.openStream();
		BufferedInputStream fileparse= new BufferedInputStream(io);	
		PDDocument document = PDDocument.load(fileparse);
		System.out.println("Number of pages ::"+document.getNumberOfPages());
		PDFTextStripper readPdf=new PDFTextStripper();
		String text=readPdf.getText(document);
		Assert.assertFalse(text.isBlank(),"PDF file doesn't contains any text");
		document.close();
		
		return text;
	}
	public static String readPdfFilesInLocalFolders(String localFilePath) throws IOException {
		
		File file=new File(localFilePath);
		PDDocument document = PDDocument.load(file);
		System.out.println("Number of pages ::"+document.getNumberOfPages());
		PDFTextStripper readPdf=new PDFTextStripper();
		String text=readPdf.getText(document);
		Assert.assertFalse(text.isBlank(),"PDF file doesn't contains any text");
		document.close();
		return text;
	}
}
