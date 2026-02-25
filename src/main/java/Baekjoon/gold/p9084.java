package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p9084 {
    static StringBuilder sb;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            count = 0;

            int[] dp = new int[m+1];
            dp[0] = 1;
            for(int coin : a){
                for(int i = coin; i <= m; i++){
                    dp[i] += dp[i-coin];
                }
            }

            sb.append(dp[m]).append(System.lineSeparator());

        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }
}
