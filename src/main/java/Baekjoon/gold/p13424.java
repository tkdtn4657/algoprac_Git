package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p13424 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<List<Edge>> list = new ArrayList<>();

            for(int i = 0; i <= n; i++){
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.get(a).add(new Edge(b, c));
                list.get(b).add(new Edge(a, c));
            }

            int k = Integer.parseInt(br.readLine());
            FriendInfo[] friends = new FriendInfo[k];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++){
                friends[i] = new FriendInfo(Integer.parseInt(st.nextToken()));
            }

            //k개의 방에서 다익스트라를 전부 구해서
            //해당 방의 합중 가장 최소치인 값으로 방을 구해야함
            //만약 그러한 장소가 여러 개일 경우, 그중 번호가 가장 작은 방의 번호를 출력한다.
            //=> 1번노드부터 순차탐색해서 방 노드와 최소값을 같이 저장해두면 됨

            //엣지 탐색
            for(int i = 0; i < friends.length; i++){
                PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
                pq.add(new Integer[]{friends[i].roomNumber, 0});
                int[] dist = new int[n+1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[friends[i].roomNumber] = 0;

                //거리가 싼 것들을 구해야함
                while(!pq.isEmpty()){
                    Integer[] now = pq.poll();
                    if(now[1] > dist[now[0]]) continue;

                    List<Edge> nextEdges = list.get(now[0]);

                    for(Edge edge : nextEdges){
                        int nextDistance = now[1] + edge.distance;
                        if(nextDistance < dist[edge.next]){
                            dist[edge.next] = nextDistance;
                            pq.add(new Integer[]{edge.next, nextDistance});
                        }
                    }
                }

                friends[i].result = dist;

            }

            int min = Integer.MAX_VALUE;
            int minNode = 0;
            //각 노드별 거리 탐색해 min값 산정
            for(int i = 1; i <= n; i++){
                int sum = 0;
                for(FriendInfo friend : friends){
                    sum += friend.result[i];
                }
                if(min > sum){
                    min = sum;
                    minNode = i;
                }
            }

            sb.append(minNode).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static class Edge{
        int next;
        int distance;

        Edge(int next, int distance){
            this.next = next;
            this.distance = distance;
        }

    }

    private static class FriendInfo{
        int roomNumber;
        int[] result = null;

        FriendInfo(int roomNumber){
            this.roomNumber = roomNumber;
        }
    }

}
