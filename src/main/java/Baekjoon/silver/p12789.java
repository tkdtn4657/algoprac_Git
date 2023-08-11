package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.valueOf(st.nextToken()));
        }

        int order = 1;
        //queue 5 4 1 3 2
        //stack null;
        //->
        //queue
        //stack 5 4 3
        while (!queue.isEmpty()) {
            if (queue.peek() == order) {
                queue.poll();
                order++;
            } else if (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            }
            else if(!queue.isEmpty()){
                stack.add(queue.poll());
            }
        }

        if(!stack.isEmpty()){
            if(stack.peek() != order) {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
