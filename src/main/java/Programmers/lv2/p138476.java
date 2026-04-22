package Programmers.lv2;

import java.util.*;

public class p138476 {

    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 1;

            //set은 구분용으로 담아, 정렬 후 k index에서 확인하면 되는거 아니야?
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < tangerine.length; i++){
                if(map.containsKey(tangerine[i])){
                    map.put(tangerine[i], map.get(tangerine[i])+1);
                } else {
                    map.put(tangerine[i], 1);
                }
            }

            int sum = 0;
            for(Integer key : map.keySet()){
                pq.add(map.get(key));
            }

            while(!pq.isEmpty()){
                sum += pq.poll();
                if(sum < k) answer++;
            }
            return answer;
        }


    }
}
