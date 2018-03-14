/**
 * 
 */
package com.usermanagement.application;

/**
 * @author Meenu Vincent
 *
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ReadXML {

	/**
	 * Function to read and Parse XML
	 */
	public List<UserDetail> readParseXML(String fileName) {
		// TODO Auto-generated method stub
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		
		try {

			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("person");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					UserDetail user = new UserDetail();
					user.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
					user.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
					userDetails.add(user);

				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		return userDetails;

	}
	

}
