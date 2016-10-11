package org.vaadin.stepbystep.person.backend;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A domain object example. In a real application this would probably be a JPA
 * entity or DTO.
 */
@SuppressWarnings("serial")
@Entity
public class Person extends AbstractEntity {

	@NotNull(message = "First Name is required")
	@Size(min = 3, max = 40, message = "First Name must be longer than 3 and less than 40 characters")
	private String firstName;

	@NotNull(message = "Last Name is required")
	@Size(min = 3, max = 40, message = "Last Name must be longer than 3 and less than 40 characters")
	private String lastName;

	@NotNull(message = "Email is required")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Must be valid email")
	private String email;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateOfBirth;

	private boolean remind = false;

	private String picture;

	@Lob
	@Column(length = 1000)
	private String notes;

	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isRemind() {
		return remind;
	}

	public void setRemind(boolean remind) {
		this.remind = remind;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
