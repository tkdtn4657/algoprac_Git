package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //바텀업을 해야할거같음?
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+2];

        StringTokenizer st;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n; i > 0; i--){
            if(i + t[i] > n + 1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Integer.max(dp[i+1], p[i] + dp[i+t[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}