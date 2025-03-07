package ca.cal.tp2;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.*;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA(), new LivreRepositoryJPA(), new CdRepositoryJPA(),  new DvdRepositoryJPA(), new DocumentRepositoryJPA());
        PreposeService preposeService = new PreposeService(new PreposeRepositoryJPA(), new LivreRepositoryJPA(), new CdRepositoryJPA(),  new DvdRepositoryJPA());
        try{
            emprunteurService.ajoutEmprunteur("Daniel Khalil", "test", "514-221-4441");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }

        try{
            preposeService.ajoutePrepose("Alfred Wallace", "Alfeed@email.test","438 -527-6269");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }

        try{
            preposeService.entreNouveauDocument(new Livre("Lord of the ring", LocalDate.of(2005,3,17),"J.R.R. Tolkien", "155263vg36533g3", "bob", 10), 2);
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }

        try {
            preposeService.entreNouveauDocument(new CD("The Wall", LocalDate.of(2007,5,1),"Pink Floyd", 125, "Fantasy"), 0);
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }

        try {
            preposeService.entreNouveauDocument(new DVD("The Great Wall", LocalDate.of(2017,11,27),"Gorge Ford", 115, "4.5 etoiles"), 10);
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }

        try {
            emprunteurService.recherchepartitre("the");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------------------------");

        try {
            emprunteurService.recherchepartitreEtannee("Wall", LocalDate.of(2007,5,1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------------------------");

        try {
            emprunteurService.rechercheparannee(LocalDate.of(2017,11,27));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------------------------");

        try {
            emprunteurService.rechercheparauteur("J.R.R. Tolkien");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------------------------");

        try {
            emprunteurService.rechercheparartiste("Pink Floyd");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------------------------------");

        try {
            emprunteurService.recherchepardirector("Gorge Ford");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            emprunteurService.emprunterDocument("test", List.of(2, 1, 52));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Thread.currentThread().join();
    }
}
