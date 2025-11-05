package Programmers.lv1;

import java.util.*;

public class p12933 {

    class Solution {
        public long solution(long n) {
            long answer = 0;
            List<Long> list = new ArrayList<>();
            long num = 0;
            for(num = n; num > 10; num/=10){
                list.add(num%10);
            }
            list.add(num%10);

            Collections.sort(list, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }

            return Long.parseLong(sb.toString());

        }
    }
}
