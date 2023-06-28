package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2606 {
    static ArrayList<Integer>[] al;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        al = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int n) {

        visited[n] = true;

        for (int i : al[n]) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }
}
