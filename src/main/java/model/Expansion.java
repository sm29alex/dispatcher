package model;

public enum  Expansion {
    WORD,
    EXCEL;

    public static Expansion createRandom(){
        return Math.random() < 0.5 ? WORD : EXCEL ;
    }
}
