package service;

import model.Document;
import model.TypeOfDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.ArchivePrint;
import repository.QueuePrint;
import repository.QueuePrintImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class DispatcherImplTest {

    private QueuePrint queuePrint;
    private ArchivePrint archivePrint;
    private Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {

        BlockingQueue<Document> documents = new LinkedBlockingQueue<>();
        queuePrint = new QueuePrintImpl(documents);

        List<Document> archiveDocuments = new ArrayList<>();
        archivePrint = new ArchivePrint(archiveDocuments);

        dispatcher = new DispatcherImpl(queuePrint, archivePrint);

        queuePrint.put(new Document(TypeOfDocument.TYPE_0));
        queuePrint.put(new Document(TypeOfDocument.TYPE_1));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stop() throws Exception {
        assertEquals(queuePrint.getDocuments().size(), 2);
        dispatcher.stop();
    }

    @Test
    public void put() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void averageTimePrint() throws Exception {
    }

}