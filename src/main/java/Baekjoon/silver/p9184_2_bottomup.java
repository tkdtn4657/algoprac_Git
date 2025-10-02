package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9184_2_bottomup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] dp = new int[21][21][21];
        for(int a = 0; a < 21; a++){
            for(int b = 0; b < 21; b++){
                for(int c = 0; c < 21; c++){
                    if(a < 1 || b < 1 || c < 1){
                        //기본 초기화
                        dp[a][b][c] = 1;
                    } else {
                        //bottomUp 진행
                        if(a < b && b < c) {
                            dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
                        } else {
                            dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while(!(a == -1 && b == -1 && c == -1)) {
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            if(a <= 0 || b <= 0 || c <= 0){
                sb.append(dp[0][0][0]);
            } else if (a > 20 || b > 20 || c > 20) {
                sb.append(dp[20][20][20]);
            } else {
                sb.append(dp[a][b][c]);
            }
            sb.append(System.lineSeparator());

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);

    }
}
