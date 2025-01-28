package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2503_recur {

    static int answerCount = 0;
    static List<Question> questionList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            questionList.add(new Question(question, strike, ball));
        }

        for(int i = 123; i <= 987; i++){
            recur(0, i);
        }

        System.out.println(answerCount);
    }

    private static void recur(int count, int num){
        if(count == questionList.size()){
            answerCount++;
            return;
        }

        if(questionList.get(count).questionEqual(num)){
            recur(count + 1, num);
        }
    }

    private static class Question{
        int questionNumber;
        int firstNum;
        int secondNum;
        int thirdNum;
        int strike;
        int ball;

        Question(int question, int strike, int ball){
            this.questionNumber = question;
            this.strike = strike;
            this.ball = ball;

            this.firstNum = questionNumber / 100;
            this.secondNum = questionNumber % 100 / 10;
            this.thirdNum = questionNumber % 10;
        }

        public boolean questionEqual(int number) {
            int questionFirstNum = number / 100;
            int questionSecondNum = number % 100 / 10;
            int questionThirdNum = number % 10;

            if(questionSecondNum == 0 || questionThirdNum == 0){
                return false;
            }

            if(questionFirstNum == questionSecondNum || questionFirstNum == questionThirdNum || questionSecondNum == questionThirdNum){
                return false;
            }

            if(equalStrikeBall(questionFirstNum, questionSecondNum, questionThirdNum)){
                return true;
            }
            return false;
        }

        private boolean equalStrikeBall(int questionFirstNum, int questionSecondNum, int questionThirdNum){
            int strikeCount = 0;
            int ballCount = 0;

            if(questionFirstNum == this.firstNum){
                strikeCount++;
            }

            if(questionFirstNum == this.secondNum || questionFirstNum == this.thirdNum){
                ballCount++;
            }

            if(questionSecondNum == this.secondNum){
                strikeCount++;
            }

            if(questionSecondNum == this.firstNum || questionSecondNum == this.thirdNum){
                ballCount++;
            }

            if(questionThirdNum == this.thirdNum){
                strikeCount++;
            }

            if(questionThirdNum == this.firstNum || questionThirdNum == this.secondNum){
                ballCount++;
            }

            if(strikeCount == this.strike && ballCount == this.ball){
                return true;
            }
            return false;

        }
    }
}
