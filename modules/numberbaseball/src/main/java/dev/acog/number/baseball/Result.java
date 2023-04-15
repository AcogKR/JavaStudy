package dev.acog.number.baseball;

public interface Result {

    class Strike implements Result {
    }

    class Ball implements Result {
    }

    class Fail implements Result {
    }

    static String convent(Result result) {
        if (result instanceof Strike) {
            return "STRIKE";
        } else if (result instanceof Ball) {
            return "BALL";
        } else {
            return "FAIL";
        }
    }
}
