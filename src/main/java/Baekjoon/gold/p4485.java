package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p4485 {

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        while(n != 0){

            Node[][] map = new Node[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = new Node(Integer.parseInt(st.nextToken()), Integer.MAX_VALUE);
                }
            }

            map[0][0].distance = map[0][0].weight;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[2]));
            pq.add(new int[]{0, 0, map[0][0].weight});

            while(!pq.isEmpty()){
                int[] now = pq.poll();
                if(now[2] > map[now[0]][now[1]].distance) continue;

                for(int[] move : moves){
                    int dx = now[0] + move[0];
                    int dy = now[1] + move[1];

                    if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                    if(map[dx][dy].distance <= now[2] + map[dx][dy].weight) continue;
                    map[dx][dy].distance = now[2] + map[dx][dy].weight;
                    pq.add(new int[]{dx, dy, map[dx][dy].distance});
                }

            }

            sb.append("Problem ").append(count++).append(": ").append(map[n - 1][n - 1].distance).append(System.lineSeparator());
            n = Integer.parseInt(br.readLine());
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }

    private static class Node{
        int weight;
        int distance;

        public Node(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}