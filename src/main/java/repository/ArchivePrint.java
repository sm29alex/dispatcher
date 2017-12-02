package repository;

import model.Document;

import java.util.List;

public class ArchivePrint {

    private List<Document> archiveList;

    public ArchivePrint(List<Document> archiveList) {
        this.archiveList = archiveList;
    }

    public void addDocumentToArchive(Document document){
        archiveList.add(document);
    }

    public List<Document> getArchiveList() {
        return archiveList;
    }
}
