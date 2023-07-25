package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2178_BFS {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];
        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        bfs(0, 0);

        System.out.println(map[n-1][m-1]);

    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        check[i][j] = true;

        while(!q.isEmpty()) {
            int[] now =  q.poll();
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m) {
                    if (map[x][y] != 0 && !check[x][y]) { // 0이여서 갈 수 없거나 방문했음안댐
                        check[x][y] = true;
                        map[x][y] = map[now[0]][now[1]] + 1;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
