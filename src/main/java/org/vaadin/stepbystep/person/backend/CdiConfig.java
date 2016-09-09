
package org.vaadin.stepbystep.person.backend;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CdiConfig {

	/**
	 * Exposes entity manager for CDI tools like DeltaSpike Data
	 */
	@Produces
	@Dependent
	@PersistenceContext(unitName = "personsdb")
	public EntityManager entityManager;

}