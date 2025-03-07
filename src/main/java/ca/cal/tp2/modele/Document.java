package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Typedocument")
public abstract class Document {
    @Id
    @GeneratedValue
    private  int documentID;

    private  String titre;

    private  int nombreExemplaires;

    private LocalDate anneePublication;

    public Document(String titre, int nombreExemplaires, LocalDate anneePublication) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
        this.anneePublication = anneePublication;
    }

    public Document(String titre, LocalDate anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.nombreExemplaires = 0;
    }
}
