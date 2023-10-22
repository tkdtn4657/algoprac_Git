package Baekjoon.silver;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p29730 {
    public static void main(String[] args) throws IOException{
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.contains("boj.kr/") && !o2.contains("boj.kr/")){
                    return 1;
                }
                if(!o1.contains("boj.kr/") && o2.contains("boj.kr/")){
                    return -1;
                }

                if(o1.contains("boj.kr/") && o2.contains("boj.kr/")){
                    if(o1.length() > o2.length()){
                        return 1;
                    }else if(o1.length() < o2.length()){
                        return -1;
                    }
                    if(o1.length() == o2.length()){
                        for(int i = 6; i < o1.length(); i++){
                            if(o1.charAt(i) == o2.charAt(i)){
                                continue;
                            }else{
                                return o1.charAt(i) - o2.charAt(i);
                            }
                        }
                    }

                }

                if(o1.length() == o2.length()){
                    for(int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                }
                return o1.length() - o2.length();
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            pq.offer(s);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
