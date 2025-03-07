package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class CdRepositoryJPA implements DocumentRepository<CD> {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");
    @Override
    public void save(CD cd) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(cd);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int disponibilite(String titre) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<CD> query = entityManager.createQuery("SELECT c FROM CD c WHERE c.titre = :titre", CD.class);
            query.setParameter("titre", titre);
            CD cd = query.getSingleResult();
            return cd.getNombreExemplaires();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<CD> findByArtiste (String artiste) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<CD> query = entityManager.createQuery("SELECT c FROM CD c WHERE c.artiste = :artiste", CD.class);
            query.setParameter("artiste", artiste);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
