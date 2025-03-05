package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.persistance.RepositoryParent;

public class EmprunteurService{
    private final RepositoryParent<Emprunteur> utilisateurRepository;

     public EmprunteurService(RepositoryParent<Emprunteur> utilisateurRepository) {
         this.utilisateurRepository = utilisateurRepository;
     }

    public void ajoutEmprunteur(String nom, String email, String phonenumber) {
        utilisateurRepository.save(new Emprunteur(nom, email, phonenumber));
    }
}
