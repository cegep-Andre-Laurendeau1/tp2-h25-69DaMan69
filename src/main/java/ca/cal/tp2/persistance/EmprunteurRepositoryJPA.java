package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public Emprunteur findById(int id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Emprunteur> query = entityManager.createQuery("SELECT u FROM Emprunteur u WHERE u.userID = :id", Emprunteur.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getid(String email){
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Utilisateur> query = entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email", Utilisateur.class);
            query.setParameter("email", email);
            return query.getSingleResult().getUserID();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmpruntDetail emprunterpart1(Document document) {
        EmpruntDetail empruntDetail = new EmpruntDetail(LocalDate.now().plusWeeks(3), "emprunté", document);
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(empruntDetail);
            entityManager.getTransaction().commit();
            return empruntDetail;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void emprunterpart2(List<EmpruntDetail> empruntDetails, int id) {
        List<EmpruntDetail> Details = new ArrayList<>();
        Emprunt emprunt = new Emprunt(LocalDate.now(), "emprunté " + empruntDetails.size() + " document(s)", findById(id), Details);
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            for (EmpruntDetail detail : empruntDetails) {
                detail = entityManager.merge(detail);
                detail.setEmprunt(emprunt);
                Details.add(detail);
            }
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            Emprunteur emprunteur = entityManager.find(Emprunteur.class, id);
            emprunteur.getEmprunts().add(emprunt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Emprunt> getEmprunts(Emprunteur emprunteur) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Emprunt> query = entityManager.createQuery(
                    "SELECT e FROM Emprunt e WHERE e.emprunteur = :emprunteur AND e.status LIKE :status", Emprunt.class);
            query.setParameter("emprunteur", emprunteur);
            query.setParameter("status", "%emprunté%");
            List<Emprunt> emprunts = query.getResultList();
            for (Emprunt emprunt : emprunts) {
                emprunt.getEmpuntDetails().size();
            }
            return emprunts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
