package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1753_2 {

    static ArrayList<p1753_Edge>[] al;
    static boolean visited[];
    static int distance[];
    static PriorityQueue<p1753_Edge> q = new PriorityQueue<p1753_Edge>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m, startNode;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        startNode = Integer.parseInt(br.readLine());

        al = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i = 0; i < n+1; i++){
            al[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        int u, v, w;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            al[u].add(new p1753_Edge(v ,w));

        }

        //첫번째시작노드 초기화
        q.add(new p1753_Edge(startNode, 0));
        distance[startNode] = 0;

        while(!q.isEmpty()){
            p1753_Edge now = q.poll();
            int edgeToNode = now.v;
            if(visited[edgeToNode]){
                continue;
            }
            visited[edgeToNode] = true;
            for(int i = 0; i < al[edgeToNode].size(); i++){
                p1753_Edge tmp = al[edgeToNode].get(i);
                int next = tmp.v;
                int weight = tmp.w;
                if(distance[next] > distance[edgeToNode]+weight){
                    distance[next] = weight + distance[edgeToNode];
                    q.add(new p1753_Edge(next, distance[next]));
                }
            }}
        for(int i = 1; i <= n; i++){
            if(visited[i]){
                System.out.println(distance[i]);
            }
            else{
                System.out.println("INF");
            }
        }

    }
}

class p1753_Edge implements Comparable<p1753_Edge>{
//    int u;
    int v;
    int w;
    p1753_Edge(int v, int w){
//        this.u = u;
        this.v = v;
        this.w = w;
    }


    @Override
    public int compareTo(p1753_Edge o) {
        if(this.w > o.w){
            return 1;
        }
        else{
            return -1;
        }
    }
}
