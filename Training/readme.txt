Gerd:
=================================================================
* TODO Projekt test           entfernen
* TODO Projekt NeuesProjekt   entfernen
* TODO Projekt trainingServer anlegen --> das wird ein jar
       wird ein jar und enthält die Beans
* TODO Evtl. Projekt training in trainingWeb umbenennen
       enthält dann JSPs/Servlets/js/htm  


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

<settings ....>
....
<localRepository>[local Path]]\repository</localRepository>
....
</settings>

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