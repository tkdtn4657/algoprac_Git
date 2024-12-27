package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 4
 * 123 1 1
 * 356 1 0
 * 327 2 0
 * 489 0 1
 */

/**
 * A가 정답이라고 생각할 수 있는 모든 수를 넣어보기
 * B가 도전한 내용에 맞는지 확인하기
 */
public class p2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] questions = new int[100];
        int[] strikes = new int[100];
        int[] balls = new int[100];

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            questions[i] = question;
            strikes[i] = strike;
            balls[i] = ball;
        }

        //1000 * 100 = 100000

        int answer = 0;

        for(int i = 123; i <= 987; i++){
            int a = i / 100;
            int b = i % 100 / 10;
            int c = i % 10;

            if(b == 0 || c == 0){
                continue;
            }
            if(a == b || a == c || b == c){
                continue;
            }

            int answerCount = 0;
            for(int questionCount = 0; questionCount < n; questionCount++){

                int strikeCount = 0;
                int ballCount = 0;

                int questionA = questions[questionCount] / 100;
                int questionB = questions[questionCount] % 100 / 10;
                int questionC = questions[questionCount] % 10;

                if(a == questionA){
                    strikeCount++;
                }
                if(a == questionB || a == questionC){
                    ballCount++;
                }
                if(b == questionB){
                    strikeCount++;
                }
                if(b == questionA || b == questionC){
                    ballCount++;
                }
                if(c == questionC){
                    strikeCount++;
                }
                if(c == questionA || c == questionB){
                    ballCount++;
                }

                if(strikeCount == strikes[questionCount] && ballCount == balls[questionCount]){
                    answerCount++;
                }

            }
            if(answerCount == n){
                answer++;
            }
        }

        System.out.println(answer);

    }
}
