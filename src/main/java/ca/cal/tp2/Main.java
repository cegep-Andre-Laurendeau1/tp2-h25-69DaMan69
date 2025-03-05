package ca.cal.tp2;

import ca.cal.tp2.persistance.CdRepositoryJPA;
import ca.cal.tp2.persistance.DvdRepositoryJPA;
import ca.cal.tp2.persistance.EmprunteurRepositoryJPA;
import ca.cal.tp2.persistance.LivreRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA(), new LivreRepositoryJPA(), new CdRepositoryJPA(),  new DvdRepositoryJPA());
        try{
            emprunteurService.ajoutEmprunteur("Daniel", "Lemay", "514-221-4441");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }
        try{
            emprunteurService.ajoutLivre("Le seigneur des anneaux", "J.R.R. Tolkien", "155263vg36533g3", "bob", 10);
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }
        try {
            emprunteurService.ajoutCD("The Wall", "Pink Floyd", 125, "Fantasy");
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }
        try {
            emprunteurService.ajoutDVD("The Great Wall", "Gorge Ford ", 115, "4.5 etoiles");
        } catch (Exception e) {
            System.out.println("erreur bd: " + e.getMessage());
        }


        Thread.currentThread().join();
    }
}
