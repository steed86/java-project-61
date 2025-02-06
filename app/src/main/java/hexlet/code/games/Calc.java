package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void play(int roundsCount) {
        String userName = Engine.askNameAndGreet();
        System.out.println("What is the result of the expression?");
        boolean isAnswerCorrect = false;
        int correctAnswerCount = 0;

        while (correctAnswerCount < roundsCount) {
            int int1 = Engine.getRandomInt();
            int int2 = Engine.getRandomInt();
            String operatorStr = getRandomOperator();
            int correctAnswer = 0;

            if (operatorStr.equals("+")) {
                correctAnswer = int1 + int2;
            } else if (operatorStr.equals("-")) {
                correctAnswer = int1 - int2;
            } else if (operatorStr.equals("*")) {
                correctAnswer = int1 * int2;
            }

            String userAnswer = Engine.getUserAnswer(int1 + " " + operatorStr + " " + int2);

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

    public static String getRandomOperator() {
        String operatorStr = "";
        final int minOperatorCode = 1;
        final int maxOperatorCode = 3;
        final int additionOperatorCode = 1;
        final int subtractionOperatorCode = 2;
        final int multiplicationOperatorCode = 3;
        int operatorCode = Engine.getRandomInt(minOperatorCode, maxOperatorCode);

        if (operatorCode == additionOperatorCode) {
            operatorStr = "+";
        } else if (operatorCode == subtractionOperatorCode) {
            operatorStr = "-";
        } else if (operatorCode == multiplicationOperatorCode) {
            operatorStr = "*";
        }

        return operatorStr;
    }

}
