Person Service
==============

A simple JPA backend service that loads data from a CSV file and make it 
accessible through `Person` entity.

It can be easily upgraded to read/write from a real database instead of the CSV 
file.

You can modify the provided demo data from `Persons.csv` located under 
`src/resources`.

##Watch step by step on how to use this backend in a Vaadin project

[![Vaadin Demo Coding in a Youtube Video](http://img.youtube.com/vi/k47CkTx9hUw/0.jpg)](http://www.youtube.com/watch?v=k47CkTx9hUw)

Optain Maven dependecy
======================
You can optain the maven dependecy from [Vaain Directoy](https://vaadin.com/directory/#!addon/demo-person-service) without any downloads or installs. 

Import & Install Using CLI
==========================
Platform and IDE independant, you can install this project locally using the following three commands:
```bash
	$ git clone git@github.com:amahdy/person-service.git
	$ cd person-service
	$ mvn install
```
Or alternatively:

Import Into Eclipse
===================

This project is easy to import into Eclipse from the [eclipse-project branch](https://github.com/amahdy/person-service/tree/eclipse-project). Here are the direct steps to get started:

**Step 1) From Eclipse, open File, Import**

![From Eclipse, open File, Import](/readme_files/step01.png?raw=true "From Eclipse, open File, Import")

**Step 2) Select under Git, Projects from Git**

![Select under Git, Projects from Git](/readme_files/step02.png?raw=true "Select under Git, Projects from Git")

**Step 3) Select Clone URI**

![Select Clone URI](/readme_files/step03.png?raw=true "Select Clone URI")

**Step 4) Fill the URI with the repository's link**

![Fill the URI with the repository's link](/readme_files/step04.png?raw=true "Fill the URI with the repository's link")

**Step 5) Keep eclipse-project branch selected and unselect all other branches**

![Keep eclipse-project branch selected and unselect all other branches](/readme_files/step05.png?raw=true "Keep eclipse-project branch selected and unselect all other branches")

**Step 6) Specify a directory for the cloned copy of this project**

![Specify a directory for the cloned copy of this project](/readme_files/step06.png?raw=true "Specify a directory for the cloned copy of this project")

**Step 7) Select Import existing Eclipse projects**

![Select Import existing Eclipse projects](/readme_files/step07.png?raw=true "Select Import existing Eclipse projects")

**Step 8) Eclipse project will be detected and ready to be imported**

![Eclipse project will be detected and ready to be imported](/readme_files/step08.png?raw=true "Eclipse project will be detected and ready to be imported")

**Step 9) You will see the project files and Java classes**

![You will see the project files and Java classes](/readme_files/step09.png?raw=true "You will see the project files and Java classes")

**Step 10) Right click on the project, select Run As, Maven install**

![Right click on the project, select Run As, Maven install](/readme_files/step10.png?raw=true "Right click on the project, select Run As, Maven install")

**Step 11) You should get a BUILD SUCCESS in the Console, now the project is ready to be used locally**

![You should get a BUILD SUCCESS in the Console, now the project is ready to be used locally](/readme_files/step11.png?raw=true "You should get a BUILD SUCCESS in the Console, now the project is ready to be used locally")

Referencing This Project Into Another Maven Project
===================================================
After installing this project locally, you can easily reference it by including it as a dependecy into the front-end project. Most porbably you will need to include JavaEE dependencies as well:

```xml
	<dependencies>
		...
		
		<dependency>
			<groupId>javax</groupId>
			<artifactId>javaee-api</artifactId>
			<version>7.0</version>
			<scope>provided</scope>
		</dependency>
		
		<dependency>
			<groupId>org.vaadin.stepbystep</groupId>
			<artifactId>person-service</artifactId>
			<version>1.1</version>
		</dependency>
		
		...
	</dependencies>
```

Usage
=====

- Inject `PersonService`.
- Call `loadData()` to load the data from the CSV file.
- Call `getEntries()` to return a list of `Person`.
- Call `delete()` or `save()` to update a given entity.

Example
=======

```java
	@Inject
	PersonService service;

	@PostConstruct
	void load() {
		service.loadData();

		container.bind(service.getEntries());
	}
```
