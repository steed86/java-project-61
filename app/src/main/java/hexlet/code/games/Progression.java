package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void play(int roundCount) {
        String userName = Engine.askNameAndGreet();
        System.out.println("What number is missing in the progression?");
        boolean isAnswerCorrect = true;
        int correctAnswerCount = 0;
        final int minProgressionLength = 5;
        final int maxProgressionLength = 10;
        final int minCommonDifference = 1;
        final int maxCommonDifference = 5;
        int firstElementOfArray = 0;
        while (correctAnswerCount < roundCount) {
            int progressionLength = Engine.getRandomInt(minProgressionLength, maxProgressionLength);
            int[] progression = new int[progressionLength];
            int hiddenElement = Engine.getRandomInt(firstElementOfArray, progressionLength - 1);
            int progressionCommonDifference = Engine.getRandomInt(minCommonDifference, maxCommonDifference);
            String progressionString = "";
            for (int i = 0; i < progression.length; i++) {
                if (i == firstElementOfArray) {
                    progression[i] = Engine.getRandomInt();
                } else {
                    progression[i] = progression[i - 1] + progressionCommonDifference;
                }
                String progressionElement = "";
                if (i == hiddenElement) {
                    progressionElement = "..";
                } else {
                    progressionElement = String.valueOf(progression[i]);
                }

                if (i != progressionLength - 1) {
                    progressionElement = progressionElement + " ";
                }
                progressionString = progressionString + progressionElement;
            }

            int correctAnswer = progression[hiddenElement];

            String userAnswer = Engine.getUserAnswer(progressionString);

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
