package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@DiscriminatorValue("E")
public class Emprunteur extends Utilisateur{
public Emprunteur(String name,String email,String phonenumber){
    super(name,email,phonenumber);
}

}
