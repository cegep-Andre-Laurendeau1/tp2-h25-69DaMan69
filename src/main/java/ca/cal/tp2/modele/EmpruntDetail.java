package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int lineItemID;

    public LocalDate dateRetourPrevue;
    public LocalDate dateRetourActuelle;
    public String status;

    @ManyToOne
    public Emprunt emprunt;

    @ManyToOne
    public Document document;

    public EmpruntDetail(LocalDate dateRetourPrevue, String status, Document document) {
        this.dateRetourPrevue = dateRetourPrevue;
        this.status = status;
        this.document = document;
    }

    @Override
    public String toString() {
        return  document + ", dateRetourPrevue= " + dateRetourPrevue +
                ", status= '" + status + '\'';
    }
}
