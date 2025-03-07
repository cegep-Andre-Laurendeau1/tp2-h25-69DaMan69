package ca.cal.tp2.modele;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@NoArgsConstructor
@DiscriminatorValue("E")
public class Emprunteur extends Utilisateur{

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    List<Emprunt> emprunts;

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    List<Amende> amendes;

public Emprunteur(String name,String email,String phonenumber){
    super(name,email,phonenumber);
}

}
