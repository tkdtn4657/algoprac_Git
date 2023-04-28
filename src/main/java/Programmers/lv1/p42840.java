package Programmers.lv1;

import java.util.ArrayList;

public class p42840 {

    static ArrayList<Integer> result = new ArrayList<Integer>();

    public int[] solution(int[] answers) {
        int answerSize = answers.length;
//        int[] supoOne = new int[answerSize];
//        int[] supoTwo = new int[answerSize];
//        int[] supoThree = new int[answerSize];
        int[] highScore = new int[3];
        ArrayList <Integer> result = new ArrayList<Integer>();

        highScore[0] = supoOneResult(answerSize, answers);
        highScore[1] = supoTwoResult(answerSize, answers);
        highScore[2] = supoThreeResult(answerSize, answers);

        int max = highScore[0];

        if(max < highScore[1]){
            max = highScore[1];
        }
        if(max < highScore[2]){
            max = highScore[2];
        }

//        if(highScore[0] > highScore[1]){
//            max = highScore[0];
//        }else{
//            max = highScore[1];
//        }if(max < highScore[2]){
//            max = highScore[2];
//        }

        for(int i = 0; i < highScore.length; i++){
            if(highScore[i] == max) {
                result.add(highScore[i]);
            }
        }

        int[] realResult = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            realResult[i] = i+1;
        }

        return realResult;
    }

    static int supoOneResult(int a, int[] answers) {
        int[] aPattern = {1, 2, 3, 4, 5};
        int[] aArray = new int[a];

        int count = 0;

        for (int i = 0; i < a; i++) {
            aArray[i] = aPattern[i % aPattern.length];
            if (aArray[i] == answers[i]) {
                count++;
            }
        }
        return count;
    }

    static int supoTwoResult(int b, int[] answers) { // 2, 1, 2, 3, 2, 4, 2, 5 | 2, 1, 2, 3, 2, 4, 2, 5
        int[] bPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] bArray = new int[b];

        int count = 0;

        for (int i = 0; i < b; i++) {
            bArray[i] = bPattern[i % bPattern.length];
            if (bArray[i] == answers[i]) {
                count++;
            }
        }
        return count;
    }

    static int supoThreeResult(int c, int[] answers) { // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 | 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        int[] cPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cArray = new int[c];

        int count = 0;

        for (int i = 0; i < c; i++) {
            cArray[i] = cPattern[i % cPattern.length];
            if (cArray[i] == answers[i]) {
                count++;
            }
        }
        return count;
    }
}