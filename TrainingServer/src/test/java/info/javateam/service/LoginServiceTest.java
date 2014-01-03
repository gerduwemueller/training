package info.javateam.service;

import java.io.StringWriter;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

	private String format(Source source) {
		try {
			// Transformer für Ausgabe
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
	        StreamResult xmlOutput = new StreamResult(new StringWriter());
	        transformer.transform(source, xmlOutput);
	        
	        return xmlOutput.getWriter().toString();
	        
		} catch (Exception e) {
			Assert.fail("Format throws exception");
		} 
		return null;
	}
	
	@Test public void loginService() {
		try {
            
			// Request Objekt erstellen
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapRequest = messageFactory.createMessage();
			SOAPPart soapPart = soapRequest.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("log", "http://info/javateam/webservices/loginservice");
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem0 = soapBody.addChildElement("LoginRequest", "log");
            SOAPElement soapBodyElem1 = soapBodyElem0.addChildElement("username", "log");
            soapBodyElem1.setTextContent("user");
            SOAPElement soapBodyElem2 = soapBodyElem0.addChildElement("password", "log");
            soapBodyElem2.setTextContent("pass");
            soapRequest.saveChanges();

            // Request ausgeben
            System.out.println("\nRequest SOAP Message = ");
            System.out.println(format(soapRequest.getSOAPPart().getContent()));
            
            // Verbindung herstellen
            SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
            String url = "http://localhost:8080/trainingServer/endpoints";
            SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
            soapConnection.close();
            
            // Response ausgeben
            System.out.println("\nResponse SOAP Message = ");
            System.out.println(format(soapResponse.getSOAPPart().getContent()));

		} catch (Exception e) {
			Assert.fail("SOAP throws exception");
		}
		
	}
}
