package repository;

import model.Document;

import java.util.List;

public interface ArchivePrint {
    void addDocumentToArchive(Document document);
    List<Document> getArchiveList();
    Document getDocumentById(int id);
}
