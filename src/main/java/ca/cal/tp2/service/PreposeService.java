package ca.cal.tp2.service;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.persistance.RepositoryParent;

public class PreposeService {
    private final RepositoryParent<Prepose> utilisateurRepository;
    private final RepositoryParent<Livre> livreRepository;
    private final RepositoryParent<CD> cdRepository ;
    private final RepositoryParent<DVD> dvdRepository;

    public PreposeService(RepositoryParent<Prepose> utilisateurRepository, RepositoryParent<Livre> livreRepository, RepositoryParent<CD> cdRepository, RepositoryParent<DVD> dvdRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public void ajoutePrepose(String nom, String email, String phonenumber) {
        utilisateurRepository.save(new Prepose(nom, email, phonenumber));
    }

    public void entreNouveauDocument(Document document,int quantite) {
        document.setNombreExemplaires(quantite);
        if(document instanceof Livre){
            livreRepository.save((Livre) document);
        }else if(document instanceof CD){
            cdRepository.save((CD) document);
        }else if(document instanceof DVD){
            dvdRepository.save((DVD) document);
        }
    }
}
