package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new Node(i));
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).nextEdges.add(new Edge(b, c));
            list.get(b).nextEdges.add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int factoryA = Integer.parseInt(st.nextToken());
        int factoryB = Integer.parseInt(st.nextToken());
        
        //이건 그냥 노드를 만들고 다익스트라로 구현하면 되는거 아닌가?
        //다익스트라 조건 : 무게가 높은 곳 우선순위로, A -> B로 가장 먼저 도착하면 종료

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        pq.add(new Integer[]{factoryA, Integer.MAX_VALUE});

        int[] dist = new int[n+1];
        dist[factoryA] = Integer.MAX_VALUE;

        int result = 0;
        while(!pq.isEmpty()){
            Integer[] now = pq.poll();
            if(now[1] < dist[now[0]]) continue;
            if(now[0] == factoryB){
                System.out.println(now[1]);
                return;
            }

            Node nowNode = list.get(now[0]);
            for(Edge e : nowNode.nextEdges){
                int nextWeight = Integer.min(now[1], e.weight);

                if(dist[e.b] < nextWeight){
                    dist[e.b] = nextWeight;
                    pq.add(new Integer[]{e.b, nextWeight});
                }
            }
        }

        System.out.println(result);
    }

    private static class Node{
        int nowNode;
        List<Edge> nextEdges = new ArrayList<>();

        Node(int nodeNumber){
            this.nowNode = nodeNumber;
        }
    }

    private static class Edge{
        int b;
        int weight;

        Edge(int b, int weight){
            this.b = b;
            this.weight = weight;
        }

    }

}
