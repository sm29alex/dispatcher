package service;

import model.Document;
import repository.ArchivePrint;
import repository.QueuePrint;

import java.util.ArrayList;
import java.util.List;

public class DispatcherImpl implements Dispatcher {

    private Thread threadPrint;

    private final QueuePrint queuePrint;
    private final ArchivePrint archivePrint;

    public void start(){
        if (threadPrint.getState() == Thread.State.NEW)
            threadPrint.start();
    }

    @Override
    public void stop() {
        System.out.println("Stop");
        if (threadPrint.getState() == Thread.State.RUNNABLE)
            threadPrint.interrupt();
    }

    @Override
    public void put(Document document) {
        queuePrint.put(document);
    }

    @Override
    public boolean remove(Document document) {
        return queuePrint.remove(document);
    }

    public DispatcherImpl(final QueuePrint queuePrint, final ArchivePrint archivePrint) {

        this.queuePrint = queuePrint;
        this.archivePrint = archivePrint;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    try {
                        while (true) {
                            Document document = queuePrint.getDocuments().peek();
                            queuePrint.print();
                            archivePrint.addDocumentToArchive(document);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Stop");
                    }
            }
        };

        this.threadPrint = new Thread(runnable);
    }

    @Override
    public int averageTimePrint() {
        int size = archivePrint.getArchiveList().size();
        if (size > 0)
            return (int) ((archivePrint.getDocumentById(size-1).getEndTime().getTime() - archivePrint.getDocumentById(0).getStartTime().getTime()) / size);
        return 0;
    }

    @Override
    public List<Document> getPrintedDocument() {
        return archivePrint.getArchiveList();
    }

    @Override
    public List<Document> getCurrentList() {
        return new ArrayList<>(queuePrint.getDocuments());
    }

    @Override
    public void printCurrentList(String orderBy) {
        queuePrint.printQueue(orderBy);
    }
}
