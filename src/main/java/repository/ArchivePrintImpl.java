package repository;

import model.Document;

import java.util.List;

public class ArchivePrintImpl implements ArchivePrint{

    private List<Document> archiveList;

    public ArchivePrintImpl(List<Document> archiveList) {
        this.archiveList = archiveList;
    }

    @Override
    public void addDocumentToArchive(Document document){
        archiveList.add(document);
    }

    @Override
    public List<Document> getArchiveList() {
        return archiveList;
    }

    @Override
    public Document getDocumentById(int id) {
        return archiveList.get(id);
    }
}
