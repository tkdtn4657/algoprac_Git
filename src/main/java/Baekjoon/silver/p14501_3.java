package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14501_3 {

    static int n;
    static int[][] a;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n][2];
        dp = new int[n];
        Arrays.fill(dp, -1);

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            a[i][0] = t;
            a[i][1] = p;
        }

        recur(0);

        System.out.println(dp[0]);
    }

    private static int recur(int index){
        if(index == n) return 0;
        if(index > n) return -9999999;

        if(dp[index] != -1){
            return dp[index];
        }

        dp[index] = Integer.max(recur(index + 1), recur(index + a[index][0]) + a[index][1]);
        return dp[index];
    }
}
