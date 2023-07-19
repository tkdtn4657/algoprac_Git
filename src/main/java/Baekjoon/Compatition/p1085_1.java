package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1085_1 { //A번 -10!
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = dp[i - 1] * i;
        }
        int mul = 7*24*60*60;

        System.out.println(dp[n] / mul);
    }

}
