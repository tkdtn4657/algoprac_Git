package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        //범위가 14층까지
        final int floor, floorNumber;
        floor = 15; floorNumber = 14;
        int[][] dp = new int[floor][floorNumber];//0~14층까지 1~14호까지

        int k, n;

        for(int i = 0; i< floorNumber; i++){//첫층 호수 채우기
            dp[0][i] = i+1;
        }
        for(int i = 0; i < floor; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < floor; i++){
            for(int j = 1; j < floorNumber; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0 ; testCase < t; testCase++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine())-1;

            sb.append(dp[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
