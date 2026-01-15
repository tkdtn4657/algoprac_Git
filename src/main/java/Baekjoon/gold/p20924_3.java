package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20924_3 {

    static int foundGigaNode = 0;
    static int prevGigaNode = 0;
    static int gigaLength = 0;
    static int maxLeafNodeLength = 0;

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
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }


        findGigaNode(r, -1, tree);
        dfs(foundGigaNode, prevGigaNode, 0, tree);

        System.out.println(gigaLength + " " + maxLeafNodeLength);

    }
    private static void findGigaNode(int cur, int parent, List<List<Edge>> tree){
        List<Edge> edges = tree.get(cur);
        foundGigaNode = cur;
        prevGigaNode = parent;

        long noParentNodeCount = edges.stream()
                .filter( edge -> parent != edge.next)
                .count();

        if(noParentNodeCount != 1) return;

        for(Edge edge : edges){
            if(edge.next == parent) continue;
            gigaLength += edge.distance;
            findGigaNode(edge.next, cur, tree);
        }

    }

    private static void dfs(int cur, int parent, int length, List<List<Edge>> tree){
        List<Edge> edges = tree.get(cur);

        maxLeafNodeLength = Integer.max(maxLeafNodeLength, length);

        for(Edge edge : edges){
            if(edge.next == parent) continue;
            dfs(edge.next, cur, length + edge.distance, tree);
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
