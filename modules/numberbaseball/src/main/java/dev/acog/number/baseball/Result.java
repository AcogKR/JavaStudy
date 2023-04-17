package dev.acog.number.baseball;

public enum Result {
    STRIKE(1),
    BALL(0),
    OUT(0)
    ;

    public final int index;

    Result(int index) {
        this.index = index;
    }

}
