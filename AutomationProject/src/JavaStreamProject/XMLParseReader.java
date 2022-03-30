package JavaStreamProject;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParseReader {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//Get the Document Builder
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Get Document
		Document document = builder.parse("C:\\Users\\HARISAP\\AutomationResources\\sample.xml");
		
		//Normalize the xml Structure
		document.getDocumentElement().normalize();
		
		//Reading the xml by navigating to main tag n=and its child tags
		NodeList booklist = document.getElementsByTagName("book");
		for(int i =0; i <booklist.getLength(); i++ ) {
			Node book =  booklist.item(i);
			if(book.getNodeType() == Node.ELEMENT_NODE) {
				Element bookElement = (Element) book;
				System.out.println("Tagname:::"+bookElement.getTagName()+"    " +"Tagvalues:::"+bookElement.getAttribute("id"));
				
				NodeList bookDetails = book.getChildNodes();
				for(int j = 0; j < bookDetails.getLength(); j++ ) {
					Node bookChild =  bookDetails.item(j);
					if(bookChild.getNodeType() == Node.ELEMENT_NODE) {
						Element childElement = (Element) bookChild;  
						
						System.out.println("    " + childElement.getTagName() + " : " + childElement.getTextContent());
					}
					
					
				}
			}
			 
		}
		
		
		
		
		
	}
}
