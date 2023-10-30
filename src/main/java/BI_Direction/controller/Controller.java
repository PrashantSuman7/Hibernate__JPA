package BI_Direction.controller;

import BI_Direction.dao.AdhaarDao;
import BI_Direction.dao.PersonDao;
import BI_Direction.dto.Adhaar;
import BI_Direction.dto.Person;

public class Controller {
	public static void main(String[] args) {
//		Person person=new Person();
//		person.setName("Prashant");
//		person.setAddress("Siwan");
//		Adhaar adhaar=new Adhaar();
//		adhaar.setName("Prashant");
//		adhaar.setAddress("Dadri");
//		PersonDao dao=new PersonDao();
//		dao.savePerson(person);
//		AdhaarDao adhaarDao=new AdhaarDao();
//		adhaarDao.saveAdhaar(2, adhaar);
	
		PersonDao dao=new PersonDao();
		dao.fetchPersonById(2);
		AdhaarDao adhaarDao=new AdhaarDao();
//		adhaarDao.deleteAdhaar(1);
	}

}
