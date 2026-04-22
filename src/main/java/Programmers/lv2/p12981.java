package Programmers.lv2;

import java.util.*;

public class p12981 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            //단어는 Set에 저장하고, 라운드를 갖고 있는 수를 저장
            //words를 주체로 돌리면서, n만큼 카운트가 차면 라운드를 올림
            int people = 1;
            int round = 1;
            char prevLastChar = words[0].charAt(0);
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < words.length; i++){
                if(set.contains(words[i]) || prevLastChar != words[i].charAt(0)){
                    return new int[]{people, round};
                }

                set.add(words[i]);
                prevLastChar = words[i].charAt(words[i].length()-1);

                people++;
                if(people > n){
                    people = 1;
                    round++;
                }
            }


            return answer;
        }
    }
}
