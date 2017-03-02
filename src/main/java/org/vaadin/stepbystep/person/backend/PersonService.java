package org.vaadin.stepbystep.person.backend;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * EJB to hide JPA related stuff from the UI layer.
 */
@Stateless
public class PersonService {

	@Inject
	PersonRepository entryRepo;

	@PersistenceContext(unitName = "personsdb")
	EntityManager em;

	public PersonService() {
	}

	public List<Person> getEntries() {
		return entryRepo.findAll();
	}

	public Person save(Person entity) {
		return entryRepo.saveAndFlush(entity);
	}

	public void delete(Person entity) {
		// Hibernate cannot remove detached, reattach...
		entryRepo.removeAndFlush(entryRepo.findBy(entity.getId()));
	}

	public void loadData() {

		if(entryRepo.count() != 0) {
			return;
		}

		// Fill in demo data

		String csvFile = "Persons.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(csvFile);
			br = new BufferedReader(new InputStreamReader(inputStream));

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yy")
					.withLocale(Locale.US);

			while ((line = br.readLine()) != null) {
				String[] person = line.split(cvsSplitBy);

				Person entry = new Person();
				// entry.setId(Long.parseLong(person[0]));
				entry.setFirstName(person[1]);
				entry.setLastName(person[2]);
				entry.setEmail(person[3]);
				entry.setDateOfBirth(LocalDate.parse(person[4], dtf));
				entry.setRemind(Math.random() > 0.5);
				entry.setPicture(person[5]);
				entry.setNotes(person[6]);

				em.persist(entry);
				em.flush();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
