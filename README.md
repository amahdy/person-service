Person Service
==============

A simple JPA backend service that loads data from a CSV file and make it 
accessible through `Person` entity.

It can be easily upgraded to read/write from a real database instead of the CSV 
file.

You can modify the provided demo data from `Persons.csv` located under 
`src/resources`.

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
