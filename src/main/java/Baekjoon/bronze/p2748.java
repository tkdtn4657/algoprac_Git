package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2748 {
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[91];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        topDown(n);

        System.out.println(dp[n]);
    }

    static long topDown(int i){
        if(dp[i] != -1){//계산되어있는 값
            return dp[i];
        }else{
            return dp[i] = topDown(i-2) + topDown(i-1);
        }
    }
}
