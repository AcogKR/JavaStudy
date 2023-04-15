package dev.acog.number.baseball;

import java.util.*;

public class BaseballGame {

    private final static Scanner scanner = new Scanner(System.in);

    private int tryCount = 0;
    private boolean state = true;
    private final List<Integer> numbers = GameNumber.rand();

    private BaseballGame() {
        loop();
    }

    public static void start() {
        new BaseballGame();
    }

    private void loop() {
        Message.start();
        while (state) {

            this.tryCount += 1;
            Message.read();
            List<Integer> input = GameNumber.convert(scanner.nextLine());

            if (input == null) {
                Message.exception();
                continue;
            }
            if (input.size() < 4) {
                Message.error();
                continue;
            }

            Map<Integer, Result> result = GameNumber.result(numbers, input);
            Message.check(tryCount, result);
            this.state = update(result);
        }
        Message.end(tryCount);
    }


    private boolean update(Map<Integer, Result> results) {
        int index = 0;
        for (Map.Entry<Integer, Result> entry : results.entrySet()) {
            if (entry.getValue() instanceof Result.Strike) {
                index += 1;
            }
        }
        return index < 4;
    }


    private static class Message {

        public static void read() {
            Arrays.asList(
                    "",
                    "본인이 생각하는 숫자들을 입력 해주세요 ex > 1 2 4 5"
            ).forEach(System.out::println);
            System.out.print(" > ");
        }

        public static void check(int tryCount, Map<Integer, Result> results) {
            List<String> messages = new ArrayList<>();

            messages.add(tryCount + " 라운드 결과");
            for (Map.Entry<Integer, Result> entry : results.entrySet()) {
                messages.add(entry.getKey() + 1 + "번 : " + Result.convent(entry.getValue()));
            }

            messages.forEach(System.out::println);
        }

        public static void start() {
            Arrays.asList(
                    "숫자야구 게임을 시작합니다.",
                    "컴퓨터가 랜덤으로 지정한 4가지의 숫자를 일치 시켜 승리하는 게임 입니다",
                    "플레이어는 4가지의 숫자를 입력하면 답변을 받거나 게임을 승리 합니다.",
                    "숫자의 위치와 값이 같다면 STRIKE, 숫자가 랜덤한 값중 존재한다면 BALL",
                    "아무것도 아니라면 FAIL 라는 결과가 나옵니다. 즐겨봅시다!"
            ).forEach(System.out::println);
        }

        public static void end(int tryCount) {
            Arrays.asList(
                    "",
                    "게임을 승리하셨습니다",
                    "총 시도 횟수 " + tryCount,
                    ""
            ).forEach(System.out::println);
        }

        public static void exception() {
            System.out.println("숫자 캐스팅에 문제가 있습니다 다시 입력하세요.");
        }

        public static void error() {
            System.out.println("4개의 숫자를 입력 해주셔야 합니다.");
        }

    }
}
