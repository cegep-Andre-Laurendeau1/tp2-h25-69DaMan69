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
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int borrowID;

    private LocalDate dateEmprunt;
    private String status;

    @ManyToOne
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDetail> empuntDetails;

    public Emprunt(LocalDate dateEmprunt, String status, Emprunteur emprunteur, List<EmpruntDetail> empuntDetails) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.emprunteur = emprunteur;
        this.empuntDetails = empuntDetails;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "empuntDetails= " + empuntDetails +
                '}';
    }
}
