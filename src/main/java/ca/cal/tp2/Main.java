package ca.cal.tp2;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.*;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA(), new LivreRepositoryJPA(), new CdRepositoryJPA(),  new DvdRepositoryJPA());
        PreposeService preposeService = new PreposeService(new PreposeRepositoryJPA(), new LivreRepositoryJPA(), new CdRepositoryJPA(),  new DvdRepositoryJPA());
        try{
            emprunteurService.ajoutEmprunteur("Daniel", "Lemay", "514-221-4441");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }

        try{
            preposeService.ajoutePrepose("Alfred Wallace", "Alfeed@email.test","438 -527-6269");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }

        try{
            preposeService.entreNouveauDocument(new Livre("Le seigneur des anneaux", "J.R.R. Tolkien", "155263vg36533g3", "bob", 10));
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }
        try {
            preposeService.entreNouveauDocument(new CD("The Wall", "Pink Floyd", 125, "Fantasy"));
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }
        try {
            preposeService.entreNouveauDocument(new DVD("The Great Wall", "Gorge Ford ", 115, "4.5 etoiles"));
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }


        Thread.currentThread().join();
    }
}
