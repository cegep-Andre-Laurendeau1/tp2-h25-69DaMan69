package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    List<EmpruntDetail> empruntDetails;

    public Document(String titre, LocalDate anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.nombreExemplaires = 0;
    }

    @Override
    public String toString() {
        return "documentID= " + documentID +
                ", titre= '" + titre + '\'' +
                ", nombreExemplaires= " + nombreExemplaires +
                ", anneePublication= " + anneePublication;
    }
}
