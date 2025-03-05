package ca.cal.tp1.modele;

import lombok.Data;

@Data
public class CD extends Document {
    public final String artiste;
    public final int duree;
    public final String genre;
}
