package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //1 : 1
        //2 : 11, 00
        //3 : 100, 111, 001
        //4 : 1001, 1100, 1111, 0011, 0000
        //5 : 00001, 00100, 00111, 10000, 10011, 11001, 11100, 11111

        int[] dp = new int[n+1];
        if(n <= 3) {
            System.out.println(n);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }

        System.out.println(dp[n]);

    }
}
