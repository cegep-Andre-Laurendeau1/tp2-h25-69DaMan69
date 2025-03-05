package ca.cal.tp1.modele;

import lombok.Data;

import java.sql.Date;
@Data
public class Amende {
    public final int fineID;
    public final double montant;
    public final Date dateCreation;
    public final boolean status;
}
