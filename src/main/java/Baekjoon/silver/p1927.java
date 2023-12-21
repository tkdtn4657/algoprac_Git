package Baekjoon.silver;

import java.io.*;
import java.util.*;

class p1927{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int inputNum = Integer.parseInt(br.readLine());
            if(inputNum == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(inputNum);
            }
        }
        System.out.println(sb);
    }
}
