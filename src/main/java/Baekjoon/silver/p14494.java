package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * dp 다차원배열 도달할 수 있는 경우의 수
 */
public class p14494 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;

        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1001][1001];

        for(int i = 1; i <= n; i++){
            dp[i][1] = 1;
        }

        for(int i = 1; i <= m; i++){
            dp[1][i] = 1;
        }
        //값 초기화 끝

        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= m; j++){
                dp[i][j] = (((dp[i-1][j] + dp[i][j-1]) % 1000000007) + dp[i-1][j-1]) % 1000000007;
            }
        }

        System.out.println(dp[n][m]);
        
    }
}
