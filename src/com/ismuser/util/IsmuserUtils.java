package com.ismuser.util;

import com.ismuser.exception.IsmuserException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IsmuserUtils {
	
	public static Node parseXML(String matchToken, NodeList nodelist) {
		
		Node token = null;
		
		int index = 0;
		while ((token = nodelist.item(index)) != null) {
			if (token.getNodeName().equals(matchToken)) break;
			
			index++;
		}
		
		return token;
	}
	
	public static Document setupDocument(String xmlResponse) throws ParserConfigurationException,
	SAXException,
	IOException,
	IsmuserException {
		
		if (xmlResponse == null)
			throw new IsmuserException("There was an error in retrieving the response. " +
					"Please make sure that you are pointing to the correct server");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		
		builder = dbFactory.newDocumentBuilder();
		document = builder.parse(new InputSource(new StringReader(xmlResponse)));
		
		builder = dbFactory.newDocumentBuilder();
		document = builder.parse(new InputSource(new StringReader(xmlResponse)));
		Node errorNodes = IsmuserUtils.parseXML("error", document.getElementsByTagName("error"));
		
		if (errorNodes != null) throw new IsmuserException(xmlResponse);
		
		return document;
	}
}
