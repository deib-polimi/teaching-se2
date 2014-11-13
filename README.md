Java EE 7 examples for SE2 classes
=======

# Required tools
* [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). If you want to use Java 7, switch the maven.compiler.source and maven.compiler.target version in your pom.xml from 1.8 to 1.7.
* [Glassfish Open Source Edition 4.1](https://glassfish.java.net/download.html)
* Your favourite IDE for Java EE ([NetBeans for Java EE](https://netbeans.org/downloads/) (suggested), [Eclipse IDE For Java EE Developers](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr1))
* [Maven](http://maven.apache.org/download.cgi) (Optional: already integrated in both IDEs, required if you need to run maven through the CLI)
* [MySQL Community Server](http://dev.mysql.com/downloads/mysql/)

# Starting Maven Archetype

```
Group ID: com.airhacks
Artifact ID: javaee7-essentials-archetype
Version: 1.2
Repo: http://repo.maven.apache.org/maven2/
Description: Java EE 7 project template. Clean, lean and minimalistic.
```

* From CLI: Run

  ```
  mvn archetype:generate \
    -DarchetypeCatalog=http://repo.maven.apache.org/maven2/ \
    -Dfilter=com.airhacks:javaee7-essentials-archetype
  ```
* From Netbeans: File -> New Project -> Maven Project from Archetype -> Search "essentials"

* From Eclipse
  * The first time you need to add the Repo: Eclipse -> Preferences -> Maven -> Archetypes -> Add Remote Catalog... http://repo.maven.apache.org/maven2/
  * File -> New -> Project ... -> Maven Project -> Filter "essential"
    
# Glassfish

## How to start and stop the server
* From Netbeans:
	* Services tab -> Right click on Servers -> add server...
	* Services tab -> Right click on Glassfish Server -> Start/Stop
* From Eclipse:
	* Servers tab -> Right click -> New -> Server...
	* Servers tab -> Right click on Glassfish -> Start/Stop
* From CLI:
	* glassfish/bin/asadmin start-domain
	* glassfish/bin/asadmin stop-domain
	
## Access the Control Panel

Once started, go to http://localhost:4848. Default username and password are both "admin".

# Run the examples
* Download the repo for the first time, run (or use your favourite git client)

  ```
  git clone https://github.com/deib-polimi/teaching-se2.git
  ```
  for future updates of the repo, run
  
  ```
  git pull
  ```
* Open a project in your IDE:
  * Netbeans: File -> Open Project
  * Eclipse: File -> Import Project -> Existing Maven Project
* Create a connection to the glassfish server in your IDE:
  * Netbeans: "Services" tab -> Right-click on Servers -> add server
  * Eclipse: "Servers" tab -> New -> Server
* Configure the project to be run on Glassfish
  * Netbeans: Right-click on the project -> Properties -> Run -> Server: GlassFish Server
  * Eclipse: Right-click on the project -> Properties -> Server: Glassfish
* Run the project
  * Netbeans: Run
  * Eclipse: Run on server
  
# MySQL

## How to start and stop mysql server
* on Windows: [instuctions](http://dev.mysql.com/doc/mysql-startstop-excerpt/5.7/en/windows-server-first-start.html)
* on Linux / OSX:

	```
	sudo /usr/local/mysql/support-files/mysql.server [start|stop|restart]
	```
	
## How to create a database
Here are the instructions from command line, but you can do the same from your IDE or using any mysql GUI client (e.g., [MySQL Workbench](http://www.mysql.it/products/workbench/)).
* login as root (default password is empty)

	```
	shell> mysql -u root -p
	```
* create a database

	```
	mysql> create database mydb;
	```
	
These other two guides may be of interest:
* http://dev.mysql.com/doc/refman/5.7/en/resetting-permissions.html
* http://dev.mysql.com/doc/refman/5.7/en/adding-users.html

## How to connect to MySQL:
* Download [MySQL Connector/J](http://dev.mysql.com/downloads/connector/j/)
* Follow [these instructions](http://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-glassfish-config.html) to install the library and create a MySQL connection pool
* Add the url to the additional properties of the connection pool. In the end you should have all and only the following ones:
	* DatabaseName: mydb
	* User: root (or any user granted to access mydb)
	* Password: the root password
	* URL: url to the db (e.g., jdbc:mysql://localhost:3306/mydb)
	* ServerName: localhost
* Under JDBC Resources create a new resource (e.g., jdbc/mydb) and assign the new mysql pool

# Form based authentication with JDBCRealm
See the "registration" example for project configuration (web.xml, glassfish-web.xml, persistence.xml and User entity).

Follow these steps for creating a JDBCRealm: 
* enter Glassfish control panel
* Configurations -> server-config -> security -> Realms -> new...
* Use the following configuration:
	* Realm Name: must be the same referenced in the web.xml
	* Class name: JDBCRealm
	* JAAS Context: jdbcRealm
	* JNDI: your data base resource name, where username, password and group name are going to be saved (e.g., jdbc/mydb)
	* User Table: the table containing username and password (e.g., user)
	* User Name Column: the name of the column containing the username (e.g., email)
	* Password Column: the name of the column containing the password (e.g., password)
	* Group Table: the table containing username and group, can be the user table (e.g., user)
	* Group Table User Name Column: the name of the column in the Group Table containing the username (e.g., email)
	* Group Name Column: the name of the column in the Group Table containing the group name (e.g., groupname). WARNING: do not use "group", since it is a reserved word and queries will fail
	* Password Encryption Algorithm: MD5
	* Digest Algorithm: SHA-256
* Server restart may be required
	
# Interesting Links
* [Java EE 7 Official Documentation](https://docs.oracle.com/javaee/)
* [Official java ee 7 Tutorial examples](https://github.com/javaee-samples/javaee7-samples)
* [A lot of interesting examples by Adam Bien](https://kenai.com/projects/javaee-patterns/sources/hg/show)
* [JSON schema to POJO](http://www.jsonschema2pojo.org)
