package Programmers.lv2;

public class p12945 {
    class Solution {
        int[] dp;
        public int solution(int n) {
            int answer = 0;
            dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            answer = fibo(n);

            return answer;
        }

        private int fibo(int n){
            if(dp[n] != 0){
                return dp[n];
            }
            if(n == 0){
                return dp[0];
            } else if(n == 1){
                return dp[1];
            } else {
                dp[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
                return dp[n];
            }
        }
    }
}
