package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@DiscriminatorValue("Livre")
public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public Livre(String titre, LocalDate anneePublication, String auteur, String isbn, String editeur, int nombrepages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.ISBN = isbn;
        this.editeur = editeur;
        this.nombrePages = nombrepages;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }
}
