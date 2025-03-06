package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.RepositoryParent;

import java.util.Objects;

public class EmprunteurService{
    private final RepositoryParent<Emprunteur> utilisateurRepository;
    private final RepositoryParent<Livre> livreRepository;
    private final RepositoryParent<CD> cdRepository ;
    private final RepositoryParent<DVD> dvdRepository;

     public EmprunteurService(RepositoryParent<Emprunteur> utilisateurRepository, RepositoryParent<Livre> livreRepository, RepositoryParent<CD> cdRepository, RepositoryParent<DVD> dvdRepository) {
         this.utilisateurRepository = utilisateurRepository;
         this.livreRepository = livreRepository;
         this.cdRepository = cdRepository;
         this.dvdRepository = dvdRepository;
     }

    public void ajoutEmprunteur(String nom, String email, String phonenumber) {
        utilisateurRepository.save(new Emprunteur(nom, email, phonenumber));
    }
    
}
