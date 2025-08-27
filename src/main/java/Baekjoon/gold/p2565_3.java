package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2565_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[501];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[501];
        Arrays.fill(dp, 1);

        for(int i = 1; i < 501; i++){
            for(int j = 1; j < i; j++){
                if(a[j] == 0) continue;
                if(a[i] > a[j]){
                    dp[i] = Integer.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 501; i++){
            max = Integer.max(max, dp[i]);
        }

        System.out.println(n-max);
    }
}
