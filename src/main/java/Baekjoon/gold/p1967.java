package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1967 {
    static int maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Edge>> tree = new ArrayList<>();

        for(int i = 0; i < 10001; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Edge(b, c));
            tree.get(b).add(new Edge(a, c));
        }

        //100,000,000
        //각 노드별로 전체탐색을 돌리기
        //10000 * 10000 이니까 1억 => 1초근처? 메모리는 128MB이지만, 10000번까지만 dfs를 돌아서 괜찮을듯

        for(int i = 1; i <= n; i++){
            dfs(i, -1, tree, 0);
        }

        System.out.println(maxLength);

    }

    private static void dfs(int cur, int parent, List<List<Edge>> tree, int length){
        List<Edge> nowEdges = tree.get(cur);

        maxLength = Integer.max(maxLength, length);

        for(Edge edge : nowEdges){
            if(edge.next == parent) continue;
            dfs(edge.next, cur, tree, length + edge.distance);
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
