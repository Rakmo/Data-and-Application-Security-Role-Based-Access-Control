package com;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {
	
	
	//public String autheticateUser(String username, String password)
	public static void main(String args[])
	{		
		try {
			
			File fXmlFile = new File("./enterpriseData.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("employee");

			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{

					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("role").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
					
					
					/*if( (username.equals(eElement.getElementsByTagName("username").item(0).getTextContent().trim())) && (password.equals(eElement.getElementsByTagName("password").item(0).getTextContent().trim())))
					{
						return eElement.getAttribute("id")+"::"+eElement.getAttribute("firstname")+"::"+eElement.getAttribute("lastname")+"::"+eElement.getAttribute("role");
					}*/
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//return "null";
	}

}