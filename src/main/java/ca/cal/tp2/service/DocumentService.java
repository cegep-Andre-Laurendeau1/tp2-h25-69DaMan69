package ca.cal.tp1.service;

import ca.cal.tp1.modele.Document;
import ca.cal.tp1.persistance.DocumentRepository;

public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void ajouteDocument(Document document) {
        documentRepository.save(document);
    }

    public Document getDocument(int id) {
        return documentRepository.getDocument(id);
    }
}
