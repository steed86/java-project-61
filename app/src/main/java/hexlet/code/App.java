package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String gameChoice = scanner.next();
        int gameChoiceInt = Integer.parseInt(gameChoice);

        int roundsCount = 3;

        if (gameChoiceInt == 1) {
            String userName = Cli.askNameAndGreet();
        }
        else if (gameChoiceInt == 2) {
            Even.play(roundsCount);
        } else if (gameChoiceInt == 3) {
            Calc.play(roundsCount);
        } else if (gameChoiceInt == 4) {
            GCD.play(roundsCount);
        } else if (gameChoiceInt == 5) {
            Progression.play(roundsCount);
        } else if (gameChoiceInt == 6) {
            Prime.play(roundsCount);
        }
    }
}
