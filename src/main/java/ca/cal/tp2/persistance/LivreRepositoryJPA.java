package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LivreRepositoryJPA implements DocumentRepository<Livre> {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");
    @Override
    public void save(Livre livre) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(livre);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Livre> findByAuteur(String auteur) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class);
            query.setParameter("auteur", auteur);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
