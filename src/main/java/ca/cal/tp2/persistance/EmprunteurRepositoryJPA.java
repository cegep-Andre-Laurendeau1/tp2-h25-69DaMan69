package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmprunteurRepositoryJPA implements RepositoryParent<Emprunteur> {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("tp2.pu");
    @Override
    public void save(Emprunteur utilisateur) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(utilisateur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Emprunteur findByname(String name) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Emprunteur> query = entityManager.createQuery("SELECT e FROM Emprunteur e WHERE e.name = :name", Emprunteur.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
