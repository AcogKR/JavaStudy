package dev.acog.number.baseball;

import java.util.*;

public class BaseballGame {

    private int tryCount;
    private boolean state;
    private final GameNumber gameNumber;

    public BaseballGame() {
        this.tryCount = 0;
        this.state = true;
        this.gameNumber = new GameNumber();
    }

    public void start() {
        System.out.println("야구 게임 입니다. 숫자를 4가지 입력해서 맞추시면 됩니다");
        while (state) {
            this.tryCount += 1;
            this.state = round();
        }
        System.out.println("당신은 게임을 이겼다 시도 횟수 : " + tryCount);
    }


    private boolean round() {
        System.out.print("숫자 4 가지를 입력하세요 : ");
        String input = NumberBaseball.scanner.nextLine();
        List<Integer> numbers = parseInputString(input);
        if (numbers.size() != GameNumber.BALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("잘못 입력 하셨습니다. 숫자 4개를 입력하세요");
        }
        return validateAnswer(numbers);
    }

    private List<Integer> parseInputString(String input) {
        String[] numbers = input.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String str : numbers) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    private boolean validateAnswer(List<Integer> input) {
        int index = 0;
        for (int i = 0; i < input.size(); i++) {
            Result result = gameNumber.compare(i, input.get(i));
            System.out.println(i + "번 숫자 : " + result.toString());
            index += result.index;
        }
        return index < 4;
    }

}

