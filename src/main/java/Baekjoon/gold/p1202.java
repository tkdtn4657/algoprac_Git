package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewelPq = new PriorityQueue<>();
        PriorityQueue<Jewel> tempJewelPq = new PriorityQueue<>(
                (o1, o2) -> o2.value - o1.value);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Jewel jewel = new Jewel(m, v);
            jewelPq.add(jewel);
        }


        PriorityQueue<Integer> bagPq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            int c = Integer.parseInt(br.readLine());
            bagPq.add(c);
        }
        
        //후보힙 관점
        long sum = 0;
        while(!bagPq.isEmpty()){
            Integer bag = bagPq.poll();
            while (!jewelPq.isEmpty()) {
                Jewel jewel = jewelPq.peek();
                if (bag >= jewel.m) {
                    jewelPq.poll();
                    tempJewelPq.add(jewel);
                } else {
                    break;
                }
            }
            if(!tempJewelPq.isEmpty()){
                sum += tempJewelPq.poll().value;
            }
        }

        System.out.println(sum);

    }
    
    private static class Jewel implements Comparable<Jewel> {
        int m;
        int value;


        public Jewel(int m, int v) {
            this.m = m;
            this.value = v;
        }

        @Override
        public int compareTo(Jewel o) {
            if(o.m == this.m){
                return this.value - o.value;
            }
            return this.m - o.m;
        }
    }
}
