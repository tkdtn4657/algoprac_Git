package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12865_3 {
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] item = new int[n+1][2];
        dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){

                if(j < item[i][0]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Integer.max(
                            dp[i - 1][j - item[i][0]] + item[i][1], dp[i-1][j]
                    );
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
