package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11053_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        dp[0] = 1;

        for(int i = 1; i < n; i++){
            int max = Integer.MIN_VALUE;
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(a[i] > a[j]){
                    max = Integer.max(dp[j], max);
                    dp[i] = max+1;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result = Integer.max(dp[i], result);
        }

        System.out.println(result);
    }
}
