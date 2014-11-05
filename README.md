Java EE 7 examples for SE2 classes
=======

# Required tools
* [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Glassfish Open Source Edition 4.1](https://glassfish.java.net/download.html)
* Your favourite IDE for Java EE ([NetBeans for Java EE](https://netbeans.org/downloads/) (suggested), [Eclipse IDE For Java EE Developers](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr1))
* [Maven](http://maven.apache.org/download.cgi) (Optional: already integrated in both IDEs, required if you need to run maven through the CLI)


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
  
