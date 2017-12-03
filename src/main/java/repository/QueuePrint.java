package repository;


import model.Document;

import java.util.concurrent.BlockingQueue;

public interface QueuePrint {

    void print() throws InterruptedException;

    void put(Document document);

    boolean remove(Document document);

    BlockingQueue<Document> getDocuments();

    void printQueue(String orderby);
}
