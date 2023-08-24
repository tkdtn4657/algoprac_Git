package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14235 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // 내림차순
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int n, a;
        //첫번째 줄
        n = Integer.parseInt(br.readLine());

        //두번째 줄 이후
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if(a == 0){//a가 0이면 선물나눠주기
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                    continue;
                }
                sb.append(-1).append("\n");

            }else {//거점충전
                for (int j = 0; j < a; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(sb);

    }
}
