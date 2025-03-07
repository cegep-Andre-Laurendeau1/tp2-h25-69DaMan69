package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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
    private List<EmpuntDetail> empuntDetails;

    public Emprunt(LocalDate dateEmprunt, String status) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
    }
}
