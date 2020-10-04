package repository;

import model.Author;
import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AuthorRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public AuthorRepository() {
        managerFactory = Persistence.createEntityManagerFactory("LibraryPracticeUnit");
        entityManager = managerFactory.createEntityManager();
    }

    public void save(Author author) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
    }

    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}
