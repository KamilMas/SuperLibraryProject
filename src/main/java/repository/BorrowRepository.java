package repository;

import model.Book;
import model.Borrow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BorrowRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BorrowRepository() {
        managerFactory = Persistence.createEntityManagerFactory("LibraryPracticeUnit");
        entityManager = managerFactory.createEntityManager();
    }

    public void save(Borrow borrow) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(borrow);
        transaction.commit();
    }

    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }

}
