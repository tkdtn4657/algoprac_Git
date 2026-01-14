package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20924 {

    static int pillar = 0;
    static int maxBranch = 0;
    static boolean gigaNodeFoundFlag = false;
    
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

        dfs(r, 0, 0, 0, tree);

        System.out.println(pillar + " " + maxBranch);

    }

    private static void dfs(int cur, int parent, int sumPillar, int sumGaji, List<List<Edge>> tree){
        List<Edge> nowEdges = tree.get(cur);

        // parent 제외한 자식 수 세기 + (자식이 1개면 그 자식 정보 기억)
        int childCount = 0;
        Edge onlyChild = null;
        for (Edge nowEdge : nowEdges) {
            if (nowEdge.next == parent) continue;
            childCount++;
            onlyChild = nowEdge;
        }
        //gigaNode를 발견하지 못했다면 가지의 길이를 더해주지 않음
        if(!gigaNodeFoundFlag) {
            if (childCount == 0) {
                pillar = sumPillar;
                maxBranch = 0; // 기가노드가 리프면 가지 길이 0
                return;
            }
            if (childCount >= 2) {
                gigaNodeFoundFlag = true;
                pillar = sumPillar;

                // 기가노드부터는 가지 길이를 더하며 탐색
                for (Edge nowEdge : nowEdges) {
                    if (nowEdge.next == parent) continue;
                    dfs(nowEdge.next, cur, sumPillar, sumGaji + nowEdge.distance, tree);
                }
                return;
            }
            // childCount == 1 => 기둥 계속
            dfs(onlyChild.next, cur, sumPillar + onlyChild.distance, sumGaji, tree);
            return;

        //gigaNode를 발견했을 때 부터 가지의 길이를 더하면서 탐색
        } else {
            if (childCount == 0) {
                maxBranch = Math.max(maxBranch, sumGaji);
                return;
            }
            for (Edge nowEdge : nowEdges) {
                if (nowEdge.next == parent) continue;
                dfs(nowEdge.next, cur, sumPillar, sumGaji + nowEdge.distance, tree);
            }
        }
    }

    private static class Edge {

        int next;
        int distance;

        public Edge(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }
}
