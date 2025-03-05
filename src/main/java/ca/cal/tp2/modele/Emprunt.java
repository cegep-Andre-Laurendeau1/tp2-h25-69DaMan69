package ca.cal.tp2.modele;

import lombok.Data;

import java.sql.Date;
@Data
public class Emprunt {
    public final int borrowID;
    public final Date dateEmprunt;
    public final String status;
}
