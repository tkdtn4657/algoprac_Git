package Programmers.lv1;

public class p12954 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            long num = 0;
            int index = 0;
            while(n-->0){
                answer[index++] = num += x;
            }
            return answer;
        }
    }
}
