package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1197 {
    static Queue<Edge> edgeQueue;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edgeQueue = new PriorityQueue<>(n+9);
        parent = new int[n+1];

        //n까지만 하는 이유 : 노드는 n-1개이기에?
        for(int i = 1; i < n+1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edgeQueue.offer(new Edge(s, e, v));
        }

        int edgeCount = 0;
        int result = 0;
        while(edgeCount < n-1){
            Edge now = edgeQueue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                edgeCount++;
            }
        }

        System.out.println(result);

    }

    static void union(int s, int e){
        int a = find(s);
        int b = find(e);
        if(a != b){
            parent[b] = a;
        }
    }

    static int find(int num){
        if(parent[num] == num){
            return num;
        }else{
            int index = find(parent[num]);
            return parent[num] = index;
        }
    }
}

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int v;

    Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
        //v기준 (가중치) 오름차순
        return this.v - o.v;
    }
}
