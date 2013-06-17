package com.ismuser.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import com.ismuser.exception.IsmuserException;
import com.ismuser.util.IsmuserUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class IsmuserXML {
	
	private Document xml;
	
	public IsmuserXML(String xmlString) throws IsmuserException {
		
		try {
			this.xml = IsmuserUtils.setupDocument(xmlString);
		} catch (IOException ioe) {
			throw new IsmuserException(ioe.toString());
		} catch (ParserConfigurationException pce) {
			throw new IsmuserException(pce.toString());
		} catch (SAXException saxe) {
			throw new IsmuserException(saxe.toString());
		}
	}
	
	public boolean hasElement(String elementName, String parentElement) {
		
		Node parentNode = IsmuserUtils.parseXML(parentElement, this.xml.getElementsByTagName(parentElement));
		if (parentNode == null) return false;
		
		Node searchNode = IsmuserUtils.parseXML(elementName, parentNode.getChildNodes());
		
		return searchNode != null;
	}
	
	public String getElementValue(String elementName, String parentElement) {
		
		Node parentNode = IsmuserUtils.parseXML(parentElement, this.xml.getElementsByTagName(parentElement));
		Node searchNode = IsmuserUtils.parseXML(elementName, parentNode.getChildNodes());
		
		return searchNode == null ? null : searchNode.getTextContent();
	}
}
