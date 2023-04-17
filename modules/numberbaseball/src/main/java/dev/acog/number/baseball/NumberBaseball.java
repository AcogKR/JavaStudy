package dev.acog.number.baseball;

import java.util.Scanner;

public class NumberBaseball {

    public final static Scanner scanner = new Scanner(System.in);

    public boolean retry = true;
    public int win = 0;

    public static void main(String[] args) {
        NumberBaseball game = new NumberBaseball();
        while (game.retry) {
            new BaseballGame().start();
            game.win += 1;
            game.setRetry();
        }
        System.out.println("당신의 승리 횟수 : " + game.win);
    }

    public void setRetry() {
        System.out.print("야구게임을 더 즐기시려면 'Yes' or 'Y' 를 입력 해주세요 : ");
        String reply = scanner.nextLine().trim().toLowerCase();
        this.retry = reply.equals("y") || reply.equals("yes");
    }

}
