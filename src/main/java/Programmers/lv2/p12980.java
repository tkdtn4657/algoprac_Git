package Programmers.lv2;

import java.util.*;

public class p12980 {

    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n > 0){
                if(n % 2 == 1){
                    ans++;
                    n--;
                } else {
                    n /= 2;
                }
            }

            return ans;

        }
    }
}
