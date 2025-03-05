package ca.cal.tp1.modele;

import lombok.Data;

@Data
public class Livre extends Document {
    private final String ISBN;
    private final String auteur;
    private final String editeur;
    private final int nombrePages;
}
