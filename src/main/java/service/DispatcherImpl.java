package service;

import model.Document;
import repository.ArchivePrint;
import repository.QueuePrint;

import java.util.List;

public class DispatcherImpl implements Dispatcher {

    private Thread threadPrint;

    private final QueuePrint queuePrint;
    private final ArchivePrint archivePrint;

    @Override
    public void stop() {
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

    public DispatcherImpl(final QueuePrint queuePrint, ArchivePrint archivePrint) {

        this.queuePrint = queuePrint;
        this.archivePrint = archivePrint;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                    try {
                        while (true) {
                            queuePrint.print();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Stop");
                    }
            }
        };

        this.threadPrint = new Thread(runnable);
        this.threadPrint.start();
    }

    @Override
    public int averageTimePrint() {
        return 0;
    }

    @Override
    public List<Document> getPrintedDocument() {
        return archivePrint.getArchiveList();
    }
}
