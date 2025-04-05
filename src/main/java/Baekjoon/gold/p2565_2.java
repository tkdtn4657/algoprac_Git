package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2565_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i; j >= 0; j--){
                if(a[i][1] > a[j][1]){
                    dp[i] = Integer.max(dp[i], dp[j]+1);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result = Integer.max(dp[i], result);
        }

        System.out.println(n-result);

    }
}