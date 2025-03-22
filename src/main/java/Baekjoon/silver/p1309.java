package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1309 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n];

        if(n == 1) {
            System.out.println(3);
            return;
        }

        dp[0] = 3;
        dp[1] = 7;

        for(int i = 2; i < n; i++){
            dp[i] = ((dp[i-1] + dp[i-2]) % 9901  + dp[i-1]) % 9901;
        }

        System.out.println(dp[n-1]);

    }
}
