package dev.acog.number.baseball;

import java.util.*;

public class GameNumber {

    public static final int BALL_NUMBER_SIZE = 4;

    private final LinkedHashSet<Integer> numbers;

    public GameNumber() {
        this.numbers = gameNumberRand();
    }

    public Result compare(int index, int number) {
        if (numbers.toArray()[index].equals(number)) {
            return Result.STRIKE;
        } else if (numbers.contains(number)) {
            return Result.BALL;
        } else {
            return Result.OUT;
        }
    }

    private static LinkedHashSet<Integer> gameNumberRand() {
        Random random = new Random();
        LinkedHashSet<Integer> randomInts = new LinkedHashSet<>();

        while (randomInts.size() < BALL_NUMBER_SIZE) {
            randomInts.add(random.nextInt(10));
        }
        return randomInts;
    }
}
