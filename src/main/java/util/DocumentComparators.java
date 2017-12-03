package util;

import model.Document;

import java.util.Comparator;

public class DocumentComparators {
    public static Comparator<Document> comparatorByTimePrint = new Comparator<Document>() {
        @Override
        public int compare(Document o1, Document o2) {
            return (int) (o1.getPrintTime() - o2.getPrintTime());
        }
    };

    public static Comparator<Document> comparatorByExpansion = new Comparator<Document>() {
        @Override
        public int compare(Document o1, Document o2) {
            return o1.getExpansion().compareTo(o2.getExpansion());
        }
    };

    public static Comparator<Document> comparatorBySizeOfPrint = new Comparator<Document>() {
        @Override
        public int compare(Document o1, Document o2) {
            return o1.getSizeOfPaper().compareTo(o2.getSizeOfPaper());
        }
    };

}
