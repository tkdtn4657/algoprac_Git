package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p9084_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            int targetMoney = Integer.parseInt(br.readLine());

            int[] dp = new int[targetMoney+1];

            for(int i = 0; i <= targetMoney; i+=a[0]){
                dp[i] = 1;
            }

            for(int i = 1; i < n; i++){
                int coin = a[i];
                for(int j = coin; j <= targetMoney; j++){
                     dp[j] += dp[j - coin];
                }
            }

            sb.append(dp[targetMoney]).append(System.lineSeparator());

        }

        System.out.println(sb);

    }
}
