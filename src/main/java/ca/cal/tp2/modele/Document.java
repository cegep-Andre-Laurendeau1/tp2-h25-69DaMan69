package ca.cal.tp1.modele;

import lombok.Data;

@Data
public class Document {
    private final int documentID;
    private final String titre;
    private final int nombreExemplaires;
}
