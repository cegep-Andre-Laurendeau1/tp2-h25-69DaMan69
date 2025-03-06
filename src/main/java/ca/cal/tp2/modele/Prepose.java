package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("P")
public class Prepose extends Utilisateur { public Prepose(String name,String email,String phonenumber){
        super(name,email,phonenumber);
}

}
