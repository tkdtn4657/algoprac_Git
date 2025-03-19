package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11726_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if(n == 1){
            System.out.println(1);
            return;
        }
        if(n == 2){
            System.out.println(2);
            return;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //3 : 3 | 4 : 5 | 5 : 8 | 6 : 13 | 7 : 21 | 8 : 34 | 9 : 55
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }


//        recur(n);

        System.out.println(dp[n]);
    }

    //이게 재귀 브루트포스로 구현된 타일링 - 시간초과
    private static int recur(int number){
        if(number <= 0){
            return 0;
        }
        if(number == 1){
            return 1;
        }
        if(number == 2){
            return 2;
        }

        return recur(number - 1) + recur(number - 2);
    }

}
