package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2206 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().chars().map(c -> c - '0').toArray();
        }

        System.out.println(bfs());

    }

    private static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.x == n-1 && now.y == m-1){
                return now.distance;
            }

            for(int[] move : moves) {
                int dx = now.x + move[0];
                int dy = now.y + move[1];

                //벽을 부수지 않은 상태의 노드
                if(dx >= 0 && dx < n && dy >= 0 && dy < m && !now.broken && !visited[dx][dy][1] && map[dx][dy] == 1){
                    visited[dx][dy][1] = true;
                    queue.add(new Node(dx, dy, now.distance+1, true));
                }

                //벽 상태 유지해서 방문
                if(dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy][now.broken ? 1 : 0 ] && map[dx][dy] == 0){
                    visited[dx][dy][now.broken ? 1 : 0] = true;
                    queue.add(new Node(dx, dy, now.distance+1, now.broken));
                }
            }
        }

        return -1;
    }

    private static class Node {
        int x, y;
        int distance;
        boolean broken;

        Node(int x, int y, int distance, boolean broken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }
}

