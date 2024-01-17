package Baekjoon.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class p1094{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        //1111111111... * 64일때
        //64를 2진수로?
        //1000000 << 이게 64
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(64);
        while(!pq.isEmpty()){
            int remainNum = remainLength(pq);
            int nowNum = 0;
            if(remainNum > x){
                nowNum = pq.poll();
                nowNum/=2;
                if(remainLength(pq) + nowNum >= x){
                    pq.add(nowNum);
                }else{
                    pq.add(nowNum);
                    pq.add(nowNum);
                }
            }else if(remainNum == x){
                break;
            }
        }
        System.out.println(pq.size());
    }
    static int remainLength(PriorityQueue<Integer> pq){
        int sum = 0;
        for(int num : pq.stream().collect(Collectors.toList())){
            sum += num;
        }
        return sum;
    }
}