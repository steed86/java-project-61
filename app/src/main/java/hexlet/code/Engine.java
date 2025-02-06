package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static String askNameAndGreet() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
    public static int getRandomInt() {
        //метод генерации случайного числа по-умолчанию -  из промежутка от 1 до 99
        final int min = 1;
        final int max = 99;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static int getRandomInt(int min, int max) {
        //перегруженный метод генерации случайного числа - из заданного промежутка
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }


    public static String getUserAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();
        return userAnswer;
    }

    public static void printSuccessMessage() {
        System.out.println("Correct!");
    }
    public static void printFailureMessage(String correctAnswer, String userAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
    }

    public static void printVictoryMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void printDefeatMessage(String correctAnswer, String userAnswer, String userName) {
        printFailureMessage(correctAnswer, userAnswer);
        System.out.println("Let's try again, " + userName + "!");
    }

    public static boolean compareAnswers(String correctAnswer, String userAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    public static boolean compareAnswers(int correctAnswer, int userAnswer) {
        return userAnswer == correctAnswer;
    }
}
