package Baekjoon.silver;

import java.io.*;

public class p17212 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[] COINS = {1, 2, 5, 7};

        int money = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        int min, index = 0;
        for (int i = 8; i <= money; i++) {
            min = Integer.MAX_VALUE;
            for (int coin : COINS) {
                if (dp[i - coin] < min) {
                    index = i-coin;
                    min = dp[i - coin];
                }
            }
            dp[i] = dp[index]+1;
        }
        System.out.println(dp[money]);
    }
}