package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class DocumentRepositoryJPA {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");

    public List<Document> findByTitre(String titre) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Document> query = entityManager.createQuery("SELECT l FROM Document l WHERE LOWER(l.titre) LIKE LOWER(:titre)", Document.class);
            query.setParameter("titre", "%" + titre + "%");
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Document> findByAnnee(LocalDate annee) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Document> query = entityManager.createQuery("SELECT l FROM Document l WHERE l.anneePublication = :annee", Document.class);
            query.setParameter("annee", annee);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Document> findByTitreAndAnnee(String titre, LocalDate annee) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Document> query = entityManager.createQuery("SELECT l FROM Document l WHERE LOWER(l.titre) LIKE LOWER(:titre) AND l.anneePublication = :annee", Document.class);
            query.setParameter("titre", "%" + titre + "%");
            query.setParameter("annee", annee);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
