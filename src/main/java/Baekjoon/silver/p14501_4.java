package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14501_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] dp = new int[21];
        int[][] item = new int[21][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--){
            if(i+ item[i][0] > n) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Integer.max(dp[i + item[i][0]] + item[i][1], dp[i + 1]);
            }
        }

        System.out.println(dp[0]);

    }
}
