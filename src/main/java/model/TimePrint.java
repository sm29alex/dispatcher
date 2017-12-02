package model;

public enum TimePrint {

    TIME_300(300),
    TIME_700(700);

    long timePrint;

    TimePrint(long timePrint) {
        this.timePrint = timePrint;
    }

    public long getTimePrint() {
        return timePrint;
    }

    public static TimePrint createRandom(){
        return Math.random() < 0.0 ? TIME_300 : TIME_700;
    }

}
