package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1260_2 {

    static int n, m;
    static boolean[] check;
    static ArrayList<Integer>[] al;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        al = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }

        for(ArrayList<Integer> a: al){
            Collections.sort(a);
        }


        sb.append(v + " ");
        dfs(v);
        sb.append("\n");
        check = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int n) {
        if (!check[n]) {
            check[n] = true;
            for (int a : al[n]) {
                if (!check[a]) {
                    sb.append(a + " ");
                    dfs(a);
                }
            }
        }
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            sb.append(v + " ");
            for(int i : al[v]){
                if(!check[i]){
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
