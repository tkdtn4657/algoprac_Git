package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1 2 3 4 5 6 7
        //1 2 4 5 6 7 -> 3
        //1 2 4 5 7 -> 6
        //1 4 5 7 -> 2
        //1 4 5 -> 7
        //1 4 -> 5
        //4 -> 1
        //-> 4
        //원형이면 덱 사용하면 될듯?
        //+3을 하는데 % deque.size()로 하면 될듯

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++){
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder().append("<");
        while(!dq.isEmpty()){
            for(int i = 0; i < k; i++){
                if(i == k-1){
                    sb.append(dq.pollFirst()).append(", ");
                } else {
                    dq.addLast(dq.pollFirst());
                }
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        System.out.println(sb);


    }
}
