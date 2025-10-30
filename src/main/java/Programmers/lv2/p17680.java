package Programmers.lv2;

import java.io.*;
import java.util.*;

public class p17680 {
    public static void main(String[] args) {
        int result = new Solution().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println(result);
    }

    private static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            //LRU 알고리즘
            //최근에 참조되지 않은 것을 빼는 방식

            // List<String> nodes = new ArrayList<>();
            Map<String, Integer> nodes = new HashMap<>();

            for(int i = 0; i < cities.length; i++){

                String s = cities[i].toLowerCase();
                //키가 존재하면, index확인해서 제일 낮은거 제거
                if(nodes.containsKey(s)){
                    answer += 1;
                    if(cacheSize > 0){
                        nodes.put(s, i);
                    }
                } else {
                    if(cacheSize > 0){
                        int oldCache = Integer.MAX_VALUE;
                        String oldCacheString = "";
                        if(nodes.size() >= cacheSize){
                            for(String key : nodes.keySet()){
                                int index = nodes.get(key);
                                if(oldCache > index){
                                    oldCache = index;
                                    oldCacheString = key;
                                }
                            }
                            nodes.remove(oldCacheString);
                        }
                        nodes.put(s, i);
                    }
                    answer += 5;

                }
            }
            return answer;
        }
    }
}
