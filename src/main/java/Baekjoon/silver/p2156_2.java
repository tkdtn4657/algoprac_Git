package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2156_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //2차원 배열로?
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n][3];
        //아예 안마심
        //하나만 마심
        //두잔 마심
        //세 케이스를 구분해서 담음

        if(n == 1){
            System.out.println(a[0]);
            return;
        }

        dp[0][0] = 0;
        dp[0][1] = a[0];
        dp[0][2] = 0;
        dp[1][0] = Integer.max(dp[0][0], dp[0][1]);
        dp[1][1] = a[1];
        dp[1][2] = a[0] + a[1];

        if(n == 2){
            System.out.println(a[0] + a[1]);
            return;
        }

        for(int i = 2; i < n; i++){
            dp[i][0] = Integer.max(Integer.max(dp[i-1][2], dp[i-1][1]), dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + a[i];
            dp[i][2] = dp[i-1][1] + a[i];
        }

        System.out.println(Integer.max(Integer.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));

    }
}
