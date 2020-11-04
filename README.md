# karafExample
Apache Karaf - REST API

This example show a simple RESTful API using Apache Cxf and CRUD its data using Hibernate

Before you continue, ensure you meet the following requirements:

	* You have installed Apache Karaf.
	* You have installed Java JDK and Maven.
	* You have a basic understanding of Java and Maven.

Getting Started

1.Config Database
	For H2 database
		feature:repo-add pax-jdbc 1.3.0
		feature:install transaction jndi pax-jdbc-h2 pax-jdbc-pool-dbcp2 pax-jdbc-config jpa hibernate
		feature:install jdbc

	Create the file etc/org.ops4j.datasource-person.cfg with the following content
		osgi.jdbc.driver.name=H2
		pool=dbcp2
		xa=true
		url=jdbc:h2:mem:test
		dataSourceName=device

2.Config Blueprint for exposed Service
	feature:install aries-blueprint 

3.Config Cxf for REST API
	feature:repo-add cxf 3.4.0
	feature:install cxf-http-jetty cxf-jaxrs

4.Run the application
	Build
		mvn clean install
	Install
		bundle:install mvn:com.ttbao.example/device/1.0.0-SNAPSHOT
		bundle:install mvn:com.ttbao.example/app/1.0.0-SNAPSHOT
	
5.Test

	Goto these url for using GET
	List the device
	http://localhost:8080/

	Get the device by Id
	http://localhost/{id}

	Go to this url using POST:
	Add new device
	http://localhost:8080/

	Go to this url using PUT:
	Update device
	http://localhost:8080/{id}

	Go to this url using DELETE:
	Delete device
	http://localhost:8080/{id}

