package Baekjoon.gold;

import java.io.*;
import java.util.*;
public class p1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        if(n == 1){
            System.out.println(0);
            return;
        }
        int resultSum = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            int pqTemp = pq.poll();
            result = pqTemp;
            if(pq.isEmpty()){
                break;
            }
            result += pq.poll();
            resultSum += result;
            pq.add(result);

            //10 + 20
        }

        //10 20 29

        System.out.println(resultSum);

    }
}
