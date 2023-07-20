package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11724_2 {

    static boolean[] check;
    static ArrayList<Integer>[] al;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        al = new ArrayList[n+1];


        for(int i = 1; i < n+1; i++){
            al[i] = new ArrayList<Integer>();
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al[u].add(v);
            al[v].add(u);
        }

        int count = 0;
        for(int i = 1; i < n+1; i++) {
            if(!check[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int node){
        if(!check[node]){
            check[node] = true;
            for(int n : al[node]) {
                if(!check[n]){
                    dfs(n);
                }
            }
        }
    }
}
