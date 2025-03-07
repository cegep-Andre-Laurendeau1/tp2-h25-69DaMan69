package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@DiscriminatorValue("DVD")
public class DVD extends Document {
    public String director;
    public int duree;
    public String rating;

    public DVD(String titre, LocalDate anneePublication, String directeur, int duree, String rating) {
        super(titre, anneePublication);
        this.director = directeur;
        this.duree = duree;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
