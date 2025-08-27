package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11053_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[j] < a[i]){
                    dp[i] = Integer.max(dp[i], dp[j]+1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
