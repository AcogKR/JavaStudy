package dev.acog.number.baseball;

import java.util.*;

public class GameNumber {

    public static List<Integer> rand() {
        List<Integer> samples = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(samples);
        return new ArrayList<>(samples.subList(0, 4));
    }

    public static Map<Integer, Result> result(List<Integer> numbers, List<Integer> input) {
        Map<Integer, Result> result = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            Integer index = input.get(i);
            if (Objects.equals(numbers.get(i), index)) {
                result.put(i, new Result.Strike());
            } else if (numbers.contains(index)) {
                result.put(i, new Result.Ball());
            } else {
                result.put(i, new Result.Fail());
            }
        }

        return result;
    }

    public static List<Integer> convert(String value) {
        try {
            List<Integer> result = new ArrayList<>();
            for (String str : value.split(" ")) {
                result.add(Integer.parseInt(str));
            }
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
