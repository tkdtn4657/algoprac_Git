package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1149_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] house = new int[n][3];
        int[][] dp = new int[n][3];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            house[i][0] = r;
            house[i][1] = g;
            house[i][2] = b;

        }

        //앞뒤로 중복해서 색을 선택하면 안됨
        dp[0] = house[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = house[i][0] + Integer.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = house[i][1] + Integer.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = house[i][2] + Integer.min(dp[i-1][1], dp[i-1][0]);
        }

        System.out.println(Integer.min(dp[n-1][0], Integer.min(dp[n-1][1], dp[n-1][2])));

    }
}
