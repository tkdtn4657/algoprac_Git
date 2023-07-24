package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2606_BFS {

    static ArrayList<Integer>[] al;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        al = new ArrayList[n + 1];
        check = new boolean[n + 1];


        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }
        bfs(1);


    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        int count = 0;
        check[n] = true;

        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int s : al[nowNode]) {
                if (!check[s]) {
                    count++;
                    check[s] = true;
                    q.add(s);
                }
            }
        }

        System.out.println(count);

    }
}
