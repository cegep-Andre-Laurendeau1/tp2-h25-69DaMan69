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
public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fineID;

    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    private Emprunteur emprunteur;
}
