package repository;

import model.Document;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class QueuePrintImpl implements QueuePrint{

    private final BlockingQueue<Document> documents;

    public QueuePrintImpl(BlockingQueue<Document> documents) {
        this.documents = documents;
    }

    @Override
    public void print() throws InterruptedException {
        Document document = documents.take();
        document.setStartTime(new Date());
        System.out.println("Start print document " + document.getName() + " at " + document.getStartTime().toString());
        Thread.sleep(document.getTimeSleep());
        document.setEndTime(new Date());
        System.out.println("End print document " + document.getName() + " at " + document.getEndTime().toString());
    }

    @Override
    public void put(Document document) {
        try {
            documents.put(document);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(Document document) {
        return documents.remove(document);
    }

    @Override
    public BlockingQueue<Document> getDocuments() {
        return documents;
    }
}
