package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * dp : 각 계단 도달지의 max값
 */
public class p2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        int[] stairs = new int[n+1];

        for(int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(stairs[1]);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];


        for(int i = 3; i <= n; i++){
                dp[i] = Long.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        System.out.println(dp[n]);

    }
}
