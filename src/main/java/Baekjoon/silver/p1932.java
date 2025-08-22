package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = a[0][0];
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j <= i; j++){
                dp[i+1][j] = Integer.max(dp[i][j] + a[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Integer.max(dp[i][j] + a[i+1][j+1], dp[i+1][j+1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Integer.max(dp[n-1][i], max);
        }
        System.out.println(max);

    }
}
