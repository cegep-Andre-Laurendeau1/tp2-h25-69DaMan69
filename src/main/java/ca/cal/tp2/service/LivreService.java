package ca.cal.tp1.service;

import ca.cal.tp1.modele.Livre;
import ca.cal.tp1.persistance.LivreRepository;


public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public void ajouteLivre(Livre livre) {
        livreRepository.save(livre);
    }
    public Livre getLivre(String isbn) {
        return livreRepository.getLivre(isbn);
    }
}
