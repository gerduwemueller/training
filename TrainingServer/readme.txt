keytool -genkey -alias applet -keyalg RSA -keystore src/main/keystore/signing-jar.keystore -storepass applet -keypass applet -dname "CN=domain"


WebServiceTutorial:
=============================================================================
http://briansjavablog.blogspot.de/2013/01/spring-web-services-tutorial.html

Wird generiert:
http://localhost:8080/trainingServer/endpoint/LoginService.wsdl
http://sourceforge.net/projects/soapui/files/latest/download


=========================================================================
Folgende Packages werden durch das Goal generiert
Quelle: webapp/schemas/*.xsd
mvn jaxb2:xjc
-> info.javateam.webservices
-> info.javateam.webservices.loginservice

WebService:
-> info.javateam.services
-> info.javateam.services.impl
* endpoints rufen den service auf
