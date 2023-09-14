package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];

        //2x1의 타일은 하나만가능
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);

    }
}
