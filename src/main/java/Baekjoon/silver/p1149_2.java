package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1149_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] RGBArray = new int[n][3];
        int[][] dp = new int[n][3];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            RGBArray[i][0] = Integer.parseInt(st.nextToken());
            RGBArray[i][1] = Integer.parseInt(st.nextToken());
            RGBArray[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < 3; j++){
            dp[0][j] = RGBArray[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if( j == 0){
                    dp[i][j] = Integer.min(dp[i-1][1], dp[i-1][2]) + RGBArray[i][j];
                }
                if(j == 1){
                    dp[i][j] = Integer.min(dp[i-1][0], dp[i-1][2]) + RGBArray[i][j];
                }
                if(j == 2){
                    dp[i][j] = Integer.min(dp[i-1][0], dp[i-1][1]) + RGBArray[i][j];
                }
            }
        }

        int min = Integer.min(Integer.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.println(min);

    }
}
