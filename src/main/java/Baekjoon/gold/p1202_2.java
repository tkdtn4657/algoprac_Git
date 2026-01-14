package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1202_2 {
    public static void main(String[] args) throws IOException {
        //무게가 낮은 가방과 무게가 낮은 보석을 우선순위로 꺼내서
        //꺼낸 가방의 무게보다 보석의 무게가 초과할 때 까지 각자 비교 후
        //모든 보석을 가치가 높은 보석이 우선순위로 나올 수 있는 큐에 넣는다.
        //이후 그 큐의 값을 하나 꺼내 누적 가치를 더한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long sum = 0;
        Queue<Jewel> jewelPq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelPq.add(new Jewel(m, v));
        }

        Queue<Integer> bagPq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            int c = Integer.parseInt(br.readLine());
            bagPq.add(c);
        }

        Queue<Jewel> valuePriorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.v - o1.v);

        while(!bagPq.isEmpty()){
            Integer nowBag = bagPq.poll();
            while(!jewelPq.isEmpty()){
                Jewel nowJewel = jewelPq.peek();
                if(nowBag >= nowJewel.m){
                    valuePriorityQueue.add(jewelPq.poll());
                } else {
                    break;
                }
            }

            if(!valuePriorityQueue.isEmpty()){
                sum += valuePriorityQueue.poll().v;
            }
        }

        System.out.println(sum);

    }

    private static class Jewel implements Comparable<Jewel> {
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o){
            return this.m - o.m;
        }
    }
}
