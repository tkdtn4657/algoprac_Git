package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1912_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = a[0];
        for(int i = 1; i < n; i++){
            if(dp[i-1] + a[i] > a[i]){
                dp[i] = dp[i-1] + a[i];
            } else {
                dp[i] = a[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Integer.max(dp[i], max);
        }

        System.out.println(max);

    }
}
