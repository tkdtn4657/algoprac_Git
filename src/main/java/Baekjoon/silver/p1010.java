package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 31;
        int[][] dp= new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }

        for(int i = 2;i < n; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        int a, b;
        StringTokenizer st;
        for(int count = 0; count < t; count++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(dp[b][a]).append("\n");
        }
        System.out.println(sb);
    }
}
