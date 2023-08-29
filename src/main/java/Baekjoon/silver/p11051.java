package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11051 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 0; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
            }
        }

        System.out.println(dp[n][k]);

    }
}
