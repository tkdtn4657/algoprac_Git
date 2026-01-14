package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20924_2 {

    static int pillar = 0;
    static int gigaNode = 0;
    static int gigaNodeParent = 0;
    static long maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<List<Edge>> tree = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Edge(b, d));
            tree.get(b).add(new Edge(a, d));
        }
        //기가노드 찾기(기둥 길이)
        findGigaNode(r, r, tree);

        //기가노드 이후 리프노드의 길이 탐색
        dfs(gigaNode, gigaNodeParent, 0, tree);

        System.out.println(pillar + " " + maxLength);

    }

    private static void findGigaNode(int cur, int parent, List<List<Edge>> tree){
        gigaNode = cur;
        gigaNodeParent = parent;
        List<Edge> edges = tree.get(cur);
        int noParentCount = 0;
        for(Edge nextEdge : edges){
            if(nextEdge.next == parent) continue;
            noParentCount++;
        }

        if(noParentCount == 1){
            for(Edge edge : edges){
                if(edge.next == parent) continue;
                pillar += edge.distance;
                findGigaNode(edge.next, cur, tree);
            }
        }
    }

    private static void dfs(int cur, int parent, int length, List<List<Edge>> tree){
        List<Edge> edges = tree.get(cur);
        int noParentCount = 0;
        for(Edge nextEdge : edges){
            if(nextEdge.next == parent) continue;
            noParentCount++;
        }

        if(noParentCount == 0){
            maxLength = Long.max(maxLength, length);
        } else {
            for(Edge edge : edges){
                if(edge.next == parent) continue;
                dfs(edge.next, cur, length + edge.distance, tree);
            }
        }
    }

    private static class Edge{
        int next;
        int distance;

        public Edge(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }
}
