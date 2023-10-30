package BI_Direction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import BI_Direction.dto.Adhaar;
import BI_Direction.dto.Person;

public class AdhaarDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("rakesh").createEntityManager();
	}

	public void saveAdhaar(int id, Adhaar adhaar) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Person dbPerson = manager.find(Person.class, id);
		if (dbPerson != null) {
			transaction.begin();
			adhaar.setPerson(dbPerson);
			manager.persist(adhaar);
			dbPerson.setAdhaar(adhaar);
			transaction.commit();
		}
	}
	
	public void updateAdhaarById(int id, Adhaar adhaar) {
		EntityManager manager = getEntityManager();
		Adhaar dbAdhaar=manager.find(Adhaar.class, id);
		if(dbAdhaar!=null) {
			adhaar.setId(id);
			adhaar.setPerson(dbAdhaar.getPerson());
			EntityTransaction entityTransaction=manager.getTransaction();
			entityTransaction.begin();
			manager.merge(adhaar);
			entityTransaction.commit();
		}else {
			System.out.println("Id not Present in Database");
		}
	}
	
	public void deleteAdhaar(int id) {
		EntityManager manager = getEntityManager();
		Adhaar dbAdhaar=manager.find(Adhaar.class, id);
		if(dbAdhaar!=null) {
			EntityTransaction entityTransaction=manager.getTransaction();
			entityTransaction.begin();
			Person person=dbAdhaar.getPerson();
			person.setAdhaar(null);
			manager.remove(dbAdhaar);
			entityTransaction.commit();
		}else {
			System.out.println("Id not Present in Database");
		}
	}

}
