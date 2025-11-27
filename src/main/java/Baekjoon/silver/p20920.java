package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String inputString = br.readLine();
            if(inputString.length() < m) continue;
            //list.contains는 효율이 그렇게 좋지 않은데....
            //일단 list로 풀고 이후에 변경해볼까?

            if(map.containsKey(inputString)){
                map.put(inputString, map.get(inputString) + 1);
            } else {
                map.put(inputString, 0);
            }

        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        PriorityQueue<Word> pq = new PriorityQueue<>();
        while(iter.hasNext()){
            Map.Entry<String, Integer> next = iter.next();
            pq.add(new Word(next.getKey(), next.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb);

    }

    private static class Word implements Comparable<Word>{
        String word;
        int wordCount = 0;

        Word(String word, int wordCount){
            this.word = word;
            this.wordCount = wordCount;
        }

        @Override
        public int compareTo(Word o) {
            if(o.wordCount != this.wordCount){
                return o.wordCount - this.wordCount;
            } else {
                if(o.word.length() != this.word.length()){
                    return o.word.length() - this.word.length();
                } else {
                    return this.word.compareTo(o.word);
                }
            }

        }
    }
}
