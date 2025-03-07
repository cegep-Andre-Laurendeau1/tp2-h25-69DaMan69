package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;

import java.time.LocalDate;
import java.util.List;

public interface DocumentRepository<T> extends RepositoryParent<T>{
int disponibilite(String titre);
}
