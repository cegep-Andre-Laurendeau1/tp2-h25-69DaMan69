package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class DvdRepositoryJPA implements DocumentRepository<DVD> {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");
    @Override
    public void save(DVD dvd) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(dvd);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<DVD> findByDirector(String director) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<DVD> query = entityManager.createQuery("SELECT d FROM DVD d WHERE d.director = :director", DVD.class);
            query.setParameter("director", director);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
