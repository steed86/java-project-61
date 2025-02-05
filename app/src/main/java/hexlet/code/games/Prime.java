package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void play(int roundCount) {
        String userName = Engine.askNameAndGreet();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        boolean isAnswerCorrect = true;
        int correctAnswerCount = 0;
        while(correctAnswerCount < roundCount) {
            int questionNumber = Engine.getRandomInt();
            String correctAnswer;

            if (isNumberPrime(questionNumber)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }

            String userAnswer = Engine.getUserAnswer(String.valueOf(questionNumber));

            isAnswerCorrect = Engine.compareAnswers(correctAnswer, userAnswer);

            if (isAnswerCorrect) {
                Engine.printSuccessMessage();
                correctAnswerCount = correctAnswerCount + 1;
            } else {
                Engine.printDefeatMessage(correctAnswer, userAnswer, userName);
                break;
            }
        }

        if (isAnswerCorrect) {
            Engine.printVictoryMessage(userName);
        }
    }

    public static boolean isNumberPrime(int number) {
        for (int i = number - 1; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
