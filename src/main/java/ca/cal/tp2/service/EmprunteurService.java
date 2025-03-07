package ca.cal.tp2.service;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.persistance.*;

import java.time.LocalDate;


public class EmprunteurService{
    private final RepositoryParent<Emprunteur> utilisateurRepository;
    private final LivreRepositoryJPA livreRepository;
    private final CdRepositoryJPA cdRepository ;
    private final DvdRepositoryJPA dvdRepository;
    private DocumentRepositoryJPA documentRepository;

     public EmprunteurService(RepositoryParent<Emprunteur> utilisateurRepository, LivreRepositoryJPA livreRepository, CdRepositoryJPA cdRepository, DvdRepositoryJPA dvdRepository, DocumentRepositoryJPA documentRepository) {
         this.utilisateurRepository = utilisateurRepository;
         this.livreRepository = livreRepository;
         this.cdRepository = cdRepository;
         this.dvdRepository = dvdRepository;
         this.documentRepository = documentRepository;
     }

    public void ajoutEmprunteur(String nom, String email, String phonenumber) {
        utilisateurRepository.save(new Emprunteur(nom, email, phonenumber));
    }


    public void recherchepartitre(String titre) {
        for (Document document : documentRepository.findByTitre(titre)) {
            System.out.println(document +" "+ document.getClass().getSimpleName());
        }
    }

    public void rechercheparannee(LocalDate annee) {
        for (Document document : documentRepository.findByAnnee(annee)) {
            System.out.println(document +" "+ document.getClass().getSimpleName());
        }
    }

    public void recherchepartitreEtannee(String titre, LocalDate annee) {
        for (Document document : documentRepository.findByTitreAndAnnee(titre, annee)) {
            System.out.println(document +" "+ document.getClass().getSimpleName());
        }
    }

    public void rechercheparauteur(String auteur){
        for (Livre livre : livreRepository.findByAuteur(auteur)) {
            System.out.println(livre);
        }
    }

    public void rechercheparartiste(String artiste){
        for (CD cd : cdRepository.findByArtiste(artiste)) {
            System.out.println(cd);
        }
    }

    public void recherchepardirector(String director){
        for (DVD dvd : dvdRepository.findByDirector(director)) {
            System.out.println(dvd);
        }
    }
}
