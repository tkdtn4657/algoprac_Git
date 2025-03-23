package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Integer.max(dp[i], dp[j]+1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
