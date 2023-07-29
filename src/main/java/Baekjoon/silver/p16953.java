package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16953 {

    static ArrayList<Integer>[] al;
    static boolean[] check;
    static int[] order;
    static int n, m;
    static int count = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int u, v;
        al = new ArrayList[n+1];
        check = new boolean[n+1];
        order = new int[n+1];



        for(int i = 0; i < n+1; i++){
            al[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            al[u].add(v);
            al[v].add(u);
        }

        for(ArrayList a : al){
            Collections.sort(a, Collections.reverseOrder());
        }
        bfs(r);

        for(int i = 1; i <= n; i++){
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        check[r] = true;
        q.add(r);
        order[r] = count++;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int a : al[now]){
                if(!check[a]) {
                    check[a] = true;
                    q.add(a);
                    order[a] = count++;
                }
            }
        }
    }
}
