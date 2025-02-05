package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void play(int roundCount) {
        String userName = Engine.askNameAndGreet();
        System.out.println("Find the greatest common divisor of given numbers.");
        boolean isAnswerCorrect = true;
        int correctAnswerCount = 0;
        while(correctAnswerCount < roundCount) {
            int questionNumber1 = Engine.getRandomInt();
            int questionNumber2 = Engine.getRandomInt();
            while (questionNumber2 < questionNumber1) { //Переподбираем второе число пока оно не будет равно или больше чем первое
                questionNumber2 = Engine.getRandomInt();
            }
            int correctAnswer = 0;

            if (questionNumber2 % questionNumber1 == 0) {
                correctAnswer = questionNumber1;
            } else {
                for (int i = questionNumber1 - 1; i >= 1; i--) {
                    if ((questionNumber1 % i == 0) && (questionNumber2 % i == 0)) {
                        correctAnswer = i;
                        break;
                    }
                }
            }

            String userAnswer = Engine.getUserAnswer(questionNumber1 + " " + questionNumber2);

            isAnswerCorrect = Engine.compareAnswers(correctAnswer, Integer.parseInt(userAnswer));

            if (isAnswerCorrect) {
                Engine.printSuccessMessage();
                correctAnswerCount = correctAnswerCount + 1;
            } else {
                Engine.printDefeatMessage(String.valueOf(correctAnswer), userAnswer, userName);
                break;
            }
        }
        if (isAnswerCorrect) {
            Engine.printVictoryMessage(userName);
        }
    }
}
