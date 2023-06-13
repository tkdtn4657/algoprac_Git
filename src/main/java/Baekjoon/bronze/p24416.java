package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p24416 {
    static int fiboCount = 0;
    static int[] dp;
    static int fibonacciCount = 0;
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.print(fib(n)+" ");//재귀호출
        fibonacci(n);//DP

        System.out.println(fiboCount+1);


    }

    static int fib(int n){
        if(n == 1||n == 2){
            return 1;
        }
        else{
            return(fib(n - 1) + fib(n - 2));
        }
    }

    static int fibonacci(int n){
        dp[1] = dp[2] + 1;
        for(int i = 3; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            fiboCount++;
        }
        return dp[n];
    }
}
