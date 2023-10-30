package BI_Direction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import BI_Direction.dto.Adhaar;
import BI_Direction.dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("rakesh").createEntityManager();
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(person);
		transaction.commit();	
	}
	
	public void updatePersonById(int id ,Person person) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			person.setId(id);
			person.setAdhaar(dbPerson.getAdhaar());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("Person ID not Present in database");
		}
			
		
	}
	
	public void fetchPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null) {
			System.out.println(dbPerson.toString());
		}else {
			System.out.println("ID Not Present---");
		}
	}
	
	public void deletePersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbPerson);
			entityTransaction.commit();
		}
		else {
			System.out.println("Id not Present");
		}
	}

}
