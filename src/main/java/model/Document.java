package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Document {

    private static AtomicInteger counter = new AtomicInteger(0);

    private TypeOfDocument typeOfDocument;
    private String name;

    private Date startTime;
    private Date endTime;

    public Document(TypeOfDocument typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
        this.name = "name" + String.valueOf(counter.incrementAndGet());
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TypeOfDocument getTypeOfDocument() {
        return typeOfDocument;
    }

    public long getTimeSleep(){
        return getTypeOfDocument().getTimePrint();
    }

    public long getPrintTime(){
        return (startTime != null && endTime != null) ? getEndTime().getTime() - getStartTime().getTime() : 0 ;
    }

    public String getName() {
        return name;
    }


}
