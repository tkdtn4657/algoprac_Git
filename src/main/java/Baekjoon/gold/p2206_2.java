package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2206_2 {

    static int n, m;
    static int[][] map;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int x, y, dist;
        boolean broken;

        Node(int x, int y, int dist, boolean broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int[] row = line.chars().map(c -> c - '0').toArray();
            map[i] = row;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[n][m][2]; // 0: 안 부쉈을 때, 1: 부쉈을 때
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                return now.dist;
            }

            for (int[] move : moves) {
                int nx = now.x + move[0];
                int ny = now.y + move[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽이면
                if (map[nx][ny] == 1 && !now.broken && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new Node(nx, ny, now.dist + 1, true));
                }

                // 길이고, 현재 상태(broken 여부)에 따라 방문 안 했으면
                if (map[nx][ny] == 0 && !visited[nx][ny][now.broken ? 1 : 0]) {
                    visited[nx][ny][now.broken ? 1 : 0] = true;
                    queue.add(new Node(nx, ny, now.dist + 1, now.broken));
                }
            }
        }

        return -1;
    }
}
