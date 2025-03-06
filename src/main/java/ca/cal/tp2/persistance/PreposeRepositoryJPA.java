package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Prepose;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PreposeRepositoryJPA implements RepositoryParent<Prepose>{
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");
    @Override
    public void save(Prepose utilisateur) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(utilisateur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Prepose findByname(String name) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Prepose> query = entityManager.createQuery("SELECT e FROM Prepose e WHERE e.name = :name", Prepose.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
