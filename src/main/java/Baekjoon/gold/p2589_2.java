package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2589_2 {

    static int n;
    static int m;
    static boolean[][] visited;
    static char[][] map;
    static int maxDistance = Integer.MIN_VALUE;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        // map 다 돌아서 각 bfs 기준으로 최대거리를 가져올거야
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'W') continue;

                bfs(i, j);
                visited = new boolean[n][m];
            }
        }

        System.out.println(maxDistance);

    }

    private static void bfs(int i, int j){
        Queue<Integer[]> queue = new LinkedList<>();
        visited[i][j] = true;

        for(int[] move : moves){
            int x = i + move[0];
            int y = j + move[1];
            if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 'W' || visited[x][y]) continue;
            queue.add(new Integer[]{x, y});
        }

        int distance = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();

            for(int queueIndex = 0; queueIndex < queueSize; queueIndex++){
                Integer[] move = queue.poll();
                int nowX = move[0];
                int nowY = move[1];
                visited[nowX][nowY] = true;

                for(int[] moveXY : moves){
                    int dx = nowX + moveXY[0];
                    int dy = nowY + moveXY[1];

                    if(dx < 0 || dx >= n || dy < 0 || dy >= m || map[dx][dy] == 'W' || visited[dx][dy]) continue;
                    visited[dx][dy] = true;
                    queue.add(new Integer[]{dx, dy});
                }
            }
            distance++;
        }
        maxDistance = Integer.max(maxDistance, distance);
    }
}
