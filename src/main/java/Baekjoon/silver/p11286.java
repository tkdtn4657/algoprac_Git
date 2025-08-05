package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값에 입력한 만큼 while문을 배열에 값을 추가 및 제거한다.
        //0이 아니면, 배열에 추가
        //0이라면 배열에서 절댓값이 가장 작은 수 꺼내서 출력
        //정렬 방식은 최초 절댓값이 낮은게 들어가고, 절댓값이 같다면 작은수 즉 음수를 꺼내면 된다.

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer abs1 = Math.abs(o1);
                Integer abs2 = Math.abs(o2);

                if(abs1.equals(abs2)) return o1 - o2;

                return abs1 - abs2;
            }
        });

        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int inputNum = Integer.parseInt(br.readLine());

            if(inputNum == 0){
                if(pq.isEmpty()) {
                    sb.append(0).append(System.lineSeparator());
                    continue;
                }
                sb.append(pq.poll()).append(System.lineSeparator());
                continue;
            }

            pq.add(inputNum);
        }

        System.out.println(sb);

    }
}
