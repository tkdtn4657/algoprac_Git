package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14248 {

    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int[] a;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int now = Integer.parseInt(br.readLine());

        q.offer(now);
        int move[] = {0, 0};
        int count = 0;
        while (!q.isEmpty()) {
            now = q.poll();
            if (!visited[now]) {
                visited[now] = true;
                count++;
                move[0] = a[now];
                move[1] = a[now] * -1;
                for(int moving : move){
                    if(now + moving > 0 && now + moving <= n){
                        q.offer(now+moving);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
