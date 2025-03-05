package ca.cal.tp2;

import ca.cal.tp2.persistance.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();
        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA());
        try{
            emprunteurService.ajoutEmprunteur("Daniel", "Lemay", "514-221-4441");
        } catch (Exception e){
            System.out.println("erreur bd: " + e.getMessage());
        }
        Thread.currentThread().join();
    }
}
