package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * DFS
 * 1. I(도연)의 위치를 찾는다
 * 2. 상하좌우 DFS탐색을 통해 P를 찾는다
 * 3. P를 발견했을 때 Count를 올린다
 * 4. I의 위치를 기준으로 DFS탐색을 마치면 Count를 출력하고 프로그램 종료
 */
public class p21736 {
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static char[][] map;
    static int count = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    dfs(i, j);
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(count);

    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) { //map의 범위를 벗어났거나 해당 위치를 방문했다면 해당재귀 즉시종료
            return;
        }

        visited[x][y] = true;

        // 맵을 확인하기 위해서는 방문처리는 꼭 해야함 아니면 여러번 방문하기 때문에
        if(map[x][y] == 'X') {
            return;
        }

        if (map[x][y] == 'P') {
            count++;
        }

        for(int[] a : move){
            int moveX = a[0];
            int moveY = a[1];

            dfs(x + moveX, y + moveY);

        }
    }
}
