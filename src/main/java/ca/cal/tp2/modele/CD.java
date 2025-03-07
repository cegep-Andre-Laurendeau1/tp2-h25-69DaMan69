package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@DiscriminatorValue("CD")
public class CD extends Document {
    public String artiste;
    public int duree;
    public String genre;

    public CD(String titre, LocalDate anneePublication, String artiste, int duree, String genre) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
