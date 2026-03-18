package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1504 {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1, list);
        int[] distV1 = dijkstra(v1, list);
        int[] distV2 = dijkstra(v2, list);

        long route1 = Long.MAX_VALUE;
        long route2 = Long.MAX_VALUE;

        if(dist1[v1] != Integer.MAX_VALUE && distV1[v2] != Integer.MAX_VALUE && distV2[n] != Integer.MAX_VALUE){
            route1 = (long) dist1[v1] + distV1[v2] + distV2[n];
        }

        if(dist1[v2] != Integer.MAX_VALUE && distV2[v1] != Integer.MAX_VALUE && distV1[n] != Integer.MAX_VALUE){
            route2 = (long) dist1[v2] + distV2[v1] + distV1[n];
        }

        long answer = Long.min(route1, route2);
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);

    }

    private static int[] dijkstra(int start, List<List<Edge>> list){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new Integer[]{start, 0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            Integer[] now = pq.poll();
            if(dist[now[0]] < now[1]) continue;

            List<Edge> edges = list.get(now[0]);
            for(Edge edge : edges){
                if(dist[edge.next] > edge.weight + now[1]) {
                    dist[edge.next] = Integer.min(dist[edge.next], now[1] + edge.weight);
                    pq.add(new Integer[]{edge.next, now[1] + edge.weight});
                }
            }
        }

        return dist;

    }


    private static class Edge{
        int next;
        int weight;

        Edge(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

    }
}
