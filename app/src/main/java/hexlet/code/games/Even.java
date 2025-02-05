package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void play(int roundCount) {
        String userName = Engine.askNameAndGreet();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean isAnswerCorrect = true;
        int correctAnswerCount = 0;
        while(correctAnswerCount < roundCount) {
            //Задаём интервал для генерирования
            int questionNumber = Engine.getRandomInt();
            String correctAnswer;

            if (questionNumber % 2 == 0) {
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
}
