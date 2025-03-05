package ca.cal.tp1.modele;

import lombok.Data;

@Data
public class Utilisateur {
    private final int userID;
    private final String name;
    private final String email;
    private final String phoneNumber;
}
