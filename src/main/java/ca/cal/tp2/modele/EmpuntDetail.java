package ca.cal.tp1.modele;

import lombok.Data;

import java.sql.Date;

@Data
public class EmpuntDetail {
    public final int lineItemID;
    public final Date dateRetourPrevue;
    public final Date dateRetourActuelle;
    public final String status;
}
