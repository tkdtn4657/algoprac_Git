package Baekjoon.silver;

import java.io.*;
import java.util.*;

class p11279{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
