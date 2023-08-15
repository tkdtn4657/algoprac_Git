package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2252 {

    static ArrayList<Integer>[] al;
    static int[] inDegree;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        al = new ArrayList[n+1];
        inDegree = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            al[i] = new ArrayList<>();
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            inDegree[b]++;
        }

        topological_Sort();

        System.out.println(sb);
    }
    static void topological_Sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.offer(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now);
            for(int num : al[now]){
                if(!visited[num]) {
                    inDegree[num]--;
                }
            }

            for(int i = 1; i < inDegree.length; i++){
                if(inDegree[i] == 0 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }

            if(!q.isEmpty()){
                sb.append(" ");
            }
        }
    }
}
