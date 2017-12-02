package model;

public enum SizeOfPaper {
    A4,
    A5;

    public static SizeOfPaper createRandom(){
        return  Math.random() < 0.5 ? A4 : A5 ;
    }
}
