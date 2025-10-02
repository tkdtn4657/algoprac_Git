package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            deque.add(new Node(i+1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        Node balloonNum = deque.poll();
        sb.append(balloonNum.index).append(" ");
        while(!deque.isEmpty()){
            if(balloonNum.value > 0){
                for(int i = 0; i < balloonNum.value-1; i++){
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for(int i = 0; i < Math.abs(balloonNum.value); i++){
                    deque.addFirst(deque.pollLast());
                }
            }
            balloonNum = deque.pollFirst();
            sb.append(balloonNum.index).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static class Node{
        int index;
        int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
