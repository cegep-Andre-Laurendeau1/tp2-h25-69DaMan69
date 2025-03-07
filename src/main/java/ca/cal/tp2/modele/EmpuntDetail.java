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
public class EmpuntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int lineItemID;

    public LocalDate dateRetourPrevue;
    public LocalDate dateRetourActuelle;
    public String status;

    @ManyToOne
    public Emprunt emprunt;

    public EmpuntDetail(LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status) {
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
}
