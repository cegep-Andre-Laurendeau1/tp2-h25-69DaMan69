package ca.cal.tp1.service;

import ca.cal.tp1.modele.Utilisateur;
import ca.cal.tp1.persistance.UtilisateurRepository;

public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void ajouteUtilisateur(Utilisateur user) {
        utilisateurRepository.save(user);
    }
    public Utilisateur getUtilisateur(int id) {
        return utilisateurRepository.getUtilisateur(id);
    }
}
