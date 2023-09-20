package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * dp유형의 문제를 집어서 시작.
 * 문제 이름 : 쉬운 계단 수
 * 45656일 때 인접한(좌우) 차이가 1이다.
 * n의 자릿수가 주어졌을 때 이러한 n의 자리계단수의 총 갯수
 * n은 100까지 주어지고
 * dp배열에 담을 수는 dp[n][h]일 때
 * n : 자릿수
 * h : 높이(끝수)에 따른 경우의 수
 *
 */
public class p10844 {
    public static void main(String[] args)throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];

        //계단 높이가 1일때는 전부 1
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        if(n == 1){
            System.out.println(9);
            return;
        }

        for(int i = 2; i <= n; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j = 1; j <= 8; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long result = 0;
        for(int i = 0; i <= 9; i++){
            result = (result + dp[n][i]) % 1000000000;
        }
        System.out.println(result);
    }
}
