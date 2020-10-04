package repository;

import model.Borrow;
import model.Borrower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BorrowerRepository {


    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BorrowerRepository() {
        managerFactory = Persistence.createEntityManagerFactory("LibraryPracticeUnit");
        entityManager = managerFactory.createEntityManager();
    }

    public void save(Borrower borrower) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(borrower);
        transaction.commit();
    }

    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}
