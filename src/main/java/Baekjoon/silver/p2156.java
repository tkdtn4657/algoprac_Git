package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2156 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //연속으로 놓여 있는 3잔을 모두 마실 수는 없다..?
        //두잔까지는 연속 가능한거면 110 101 011 (010은 고려할필요없을듯? 왜냐 많이 마셔야하니까)
        //마지막 고려사항 4째부터는 011 101 110

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        if(n == 2){
            System.out.println(arr[0] + arr[1]);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Integer.max(dp[1],
                Integer.max(dp[0] + arr[2], // 101
                        arr[1] + arr[2])); // 011

        for(int i = 3; i < n; i++){
            dp[i] = Integer.max(dp[i-1], // 110
                    Integer.max(dp[i-2] + arr[i], // 101
                            dp[i-3] + arr[i-1] + arr[i])); // 011
        }

        System.out.println(dp[n-1]);
    }
}
