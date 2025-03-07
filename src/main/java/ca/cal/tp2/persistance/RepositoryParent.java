package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Utilisateur;

public interface RepositoryParent <T> {
    void save(T object);
}
