package service;

import model.Document;
import model.TypeOfDocument;

import java.util.List;

public interface Dispatcher {

    void start();
    void stop();

    void put(Document document);

    boolean remove(Document document);

    List<Document> getPrintedDocument();

    int averageTimePrint();

    List<Document> getCurrentList();

    void printCurrentList(String orderBy);
}
