package repository;


import model.Document;

import java.util.concurrent.BlockingQueue;

public interface QueuePrint {

    public void print() throws InterruptedException;

    public void put(Document document);

    public boolean remove(Document document);

    public BlockingQueue<Document> getDocuments();

}
