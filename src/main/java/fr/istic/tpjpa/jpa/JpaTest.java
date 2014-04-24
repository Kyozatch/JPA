package fr.istic.tpjpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		JpaTest te= new JpaTest(manager);
		
		tx.begin();

		// TODO create entity
		
		te.CreatePerson();
		te.ListPerson();
		
		Home h = new Home("rue rennes", "1045679", 123);
		
		// TODO persist entity
        
        manager.persist(h);
		
        tx.commit();
		// TODO run request




		System.out.println(".. done");
	}
	
    private void CreatePerson() {

        int numOfPerson = manager.createQuery("Select a From Person a", Person.class).getResultList().size();

        if (numOfPerson == 0) {

            manager.persist(new Person("Alexandre", "Lecut", true, "16/06/1992"));

            manager.persist(new Person("Léon", "Perrier", true, "27/09/1991"));
            
            manager.persist(new Person("Léa", "hamon", false, "14/07/1990"));

        }

    }
    private void ListPerson() {

        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        System.out.println("num of Person:" + resultList.size());

        for (Person next : resultList) {

            System.out.println("next person: " + next);

        }

    }

}
