package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1260_3 {
    static int n;
    static int m;
    static int v;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        for(int i = 0; i <= n; i++){
            Collections.sort(nodes.get(i));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder dfsStringBuilder = dfs(v, new StringBuilder());
        dfsStringBuilder.setLength(dfsStringBuilder.length()-1);

        sb.append(dfsStringBuilder)
                .append(System.lineSeparator())
                .append(bfs());

        System.out.println(sb);
    }

    private static StringBuilder bfs(){
        visited = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(nodes.get(v));
        visited[v] = true;
        sb.append(v + " ");


        while(!queue.isEmpty()){
            ArrayList<Integer> nowNode = queue.poll();
            for(int nextNode : nowNode){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    sb.append(nextNode + " ");
                    queue.add(nodes.get(nextNode));
                }
            }
        }
        sb.setLength(sb.length()-1);

        return sb;
    }

    private static StringBuilder dfs(int nodeNumber, StringBuilder sb){
        if(nodeNumber == v){
            sb.append(v + " ");
            visited[v] = true;
        }
        ArrayList<Integer> nowNode = nodes.get(nodeNumber);
        for(int nextNode : nowNode){
            if(!visited[nextNode]){
                visited[nextNode] = true;
                sb.append(nextNode + " ");
                dfs(nextNode, sb);
            }
        }

        return sb;
    }
}
