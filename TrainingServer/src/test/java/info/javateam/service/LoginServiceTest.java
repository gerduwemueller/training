package info.javateam.service;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

	@Test public void loginService() {
		try {
			// Transformer für Ausgabe
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

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
            transformer.transform(soapRequest.getSOAPPart().getContent(), new StreamResult(System.out));
            
            // Verbindung herstellen
            SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
            String url = "http://localhost:8080/trainingServer/endpoints";
            SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
            soapConnection.close();
            
            // Response ausgeben
            System.out.println("\nResponse SOAP Message = ");
            transformer.transform(soapResponse.getSOAPPart().getContent(), new StreamResult(System.out));
            
            
		} catch (Exception e) {
			Assert.fail("SOAP throws exception");
		}
		
	}
}
