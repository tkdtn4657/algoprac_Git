package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2161 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.poll());
            if (!q.isEmpty()) sb.append(' ');

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        System.out.println(sb);
    }
}
