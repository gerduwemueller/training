Folgende Datei suchen : apache-maven-3.1.1\conf\settings.xml
Folgendes ersetzen    : <localRepository>[local Path]]\repository</localRepository>





Tomcat 7.0/conf/tomcat-users.xml
======================================================
<tomcat-users>
....
  <role rolename="manager-gui"/>
  <role rolename="manager-script"/>
  <user username="test" password="test" roles="manager-script,manager-gui"/>
....  
</tomcat-users>

Maven 3.1.1/conf/settings.xml
======================================================
<servers>
....
    <server>
        <id>mytomcat</id>
        <username>test</username>
        <password>test</password>
    </server>
....
</servers>
    
    
Maven Kommandos:
======================================================
package tomcat7:deploy
package tomcat7:redeploy    