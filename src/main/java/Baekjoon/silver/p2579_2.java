package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2579_2 {

    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        Arrays.fill(dp, -1);

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        topDown(n);

        System.out.println(dp[n]);
    }

    static int topDown(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n >= 3) {
            //(dp[n-3] + stairs[n-1]) 이거나 dp[n-2]일때 두개 비교를 해서 넣어
            return dp[n] = Integer.max(topDown(n - 3) + stairs[n - 1], topDown(n - 2)) + stairs[n];
        }
        return 0;
    }
}
