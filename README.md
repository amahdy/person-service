Person Service
==============

A simple JPA backend service that loads data from a CSV file and make it accessible through `Person` entity.

It can be easily upgraded to read/write from a real database instead of the CSV file.

You can modify the provided demo data from `Persons.csv` located under `src/resources`.

Watch step by step on how to use this backend in a Vaadin project
-

[![Vaadin Demo Coding in a Youtube Video](http://img.youtube.com/vi/Lwhg3NrOLVA/0.jpg)](https://www.youtube.com/watch?v=Lwhg3NrOLVA)

Referencing This Project Into Another Maven Project
-

After installing this project locally, you can reference it by including it as a dependency into the front-end project. Most probably you will need to include JavaEE dependencies as well:

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
			<version>2.0</version>
		</dependency>

		...
	</dependencies>
```

Usage
-

- Inject `PersonService`.
- Call `getEntries()` to return a list of `Person`.
- Call `delete()` or `save()` to update a given entity.
- Call `getFirst()` to retrieve the first entity.
- Call `getById()` to retrieve an entity by its id.

Example
-

```java
	@Inject
	PersonService service;

	void load() {
		component.bind(service.getEntries());
	}
```

Obtain Maven dependency
-

You can obtain the maven dependency from [Vaadin Directory](https://vaadin.com/directory/#!addon/demo-person-service) without any downloads or installs.

Import & Install Using CLI
-

Platform and IDE independent, you can install this project locally using the following three commands:
```bash
	$ git clone git@github.com:amahdy/person-service.git
	$ cd person-service
	$ mvn install
```
