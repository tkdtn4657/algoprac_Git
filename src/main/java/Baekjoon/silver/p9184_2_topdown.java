package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9184_2_topdown {
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[21][21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int g = 0; g < 21; g++) {
                    dp[i][j][g] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 1;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while(!(a == -1 && b == -1 && c == -1)) {
            //탑다운 방식 calc함수 호출
            int result = calc(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append(System.lineSeparator());

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    private static int calc(int a, int b, int c){

        if(a <= 0 || b <= 0 || c <= 0){
            return dp[0][0][0];
        }

        if(a <= 20 && b <= 20 && c <= 20 && dp[a][b][c] != Integer.MAX_VALUE){
            return dp[a][b][c];
        }

        if(a > 20 || b > 20 || c > 20){
            if(dp[20][20][20] != Integer.MAX_VALUE){
                return dp[20][20][20];
            } else {
                return calc(20, 20, 20);
            }
        }

        if(a < b && b < c){
            return dp[a][b][c] = calc(a, b, c-1) + calc(a, b-1, c-1) - calc(a, b-1, c);
        } else {
            return dp[a][b][c] = calc(a-1, b, c) + calc(a-1, b-1, c) + calc(a-1, b, c-1) - calc(a-1, b-1, c-1);
        }
    }
}
