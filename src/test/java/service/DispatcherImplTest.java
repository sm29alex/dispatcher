package service;

import model.Document;
import model.TypeOfDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.ArchivePrint;
import repository.ArchivePrintImpl;
import repository.QueuePrint;
import repository.QueuePrintImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class DispatcherImplTest {

    private Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {

        BlockingQueue<Document> documents = new LinkedBlockingQueue<>();
        QueuePrint queuePrint = new QueuePrintImpl(documents);

        List<Document> archiveDocuments = new ArrayList<>();
        ArchivePrint archivePrint = new ArchivePrintImpl(archiveDocuments);

        dispatcher = new DispatcherImpl(queuePrint, archivePrint);

        queuePrint.put(new Document(TypeOfDocument.TYPE_0));
        queuePrint.put(new Document(TypeOfDocument.TYPE_1));

    }

    @After
    public void tearDown() throws Exception {
        dispatcher.stop();
    }

    @Test
    public void startAndStop (){
        assertEquals(dispatcher.getCurrentList().size(), 2);
        dispatcher.start();
        while (dispatcher.getCurrentList().size() != 0){}
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(dispatcher.getCurrentList().size(), 0);
    }

    @Test(timeout = 10000)
    public void putAndRemove() {
        assertEquals(dispatcher.getCurrentList().size(), 2);
        Document document2 = new Document(TypeOfDocument.TYPE_2);
        Document document3 = new Document(TypeOfDocument.TYPE_3);
        dispatcher.put(document2);
        dispatcher.printCurrentList("size");
        assertEquals(dispatcher.getCurrentList().size(), 3);
        dispatcher.put(document3);
        dispatcher.printCurrentList("time");
        assertEquals(dispatcher.getCurrentList().size(), 4);
        dispatcher.remove(document2);
        assertEquals(dispatcher.getCurrentList().size(), 3);
        dispatcher.remove(document3);
        assertEquals(dispatcher.getCurrentList().size(), 2);
        dispatcher.remove(document3);
        assertEquals(dispatcher.getCurrentList().size(), 2);
        dispatcher.printCurrentList("default");
        while (dispatcher.getCurrentList().size() != 0){}
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(dispatcher.getCurrentList().size(), 0);
    }


    @Test
    public void averageTimePrint() throws Exception {
        dispatcher.start();
        while (dispatcher.getCurrentList().size() != 0){}
        Thread.sleep(500);
        dispatcher.stop();
        System.out.println(dispatcher.averageTimePrint());
    }

}