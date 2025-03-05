package ca.cal.tp1.modele;

import lombok.Data;

@Data
public class DVD extends Document {
    public final String director;
    public final int duree;
    public final String rating;
}
