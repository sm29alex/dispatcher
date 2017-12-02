package model;

public class TypeOfDocument {

    public static TypeOfDocument TYPE_0 = new TypeOfDocument(TimePrint.TIME_300, SizeOfPaper.A5, Expansion.EXCEL);
    public static TypeOfDocument TYPE_1 = new TypeOfDocument(TimePrint.TIME_300, SizeOfPaper.A5, Expansion.WORD);
    public static TypeOfDocument TYPE_2 = new TypeOfDocument(TimePrint.TIME_700, SizeOfPaper.A4, Expansion.EXCEL);
    public static TypeOfDocument TYPE_3 = new TypeOfDocument(TimePrint.TIME_700, SizeOfPaper.A4, Expansion.WORD);

    private TimePrint timePrint;
    private SizeOfPaper sizeOfPaper;
    private Expansion expansion;

    private TypeOfDocument(TimePrint timePrint, SizeOfPaper sizeOfPaper, Expansion expansion) {
        this.timePrint = timePrint;
        this.sizeOfPaper = sizeOfPaper;
        this.expansion = expansion;
    }

    public long getTimePrint() {
        return timePrint.getTimePrint();
    }
}
