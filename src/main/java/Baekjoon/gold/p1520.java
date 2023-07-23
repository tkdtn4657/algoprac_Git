package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1520 {
    static int[][] map;
    static boolean[][] check;
    static int count = 0;
    static int n, m;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new boolean[n][m];
        map = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 10001); // 끝값이 제일 낮은 수가 아닐경우는?

        System.out.println(count);
    }

    static void dfs(int x, int y, int prevNumber) {
        if (x < n && y < m && x > -1 && y > -1) {
            if (x == n - 1 && y == m - 1 && map[n - 1][m - 1] < prevNumber) {//작기만 해야하는지 작거나같은지 모호한거같음
                count++;
                return;
            }

            if (!check[x][y] && prevNumber > map[x][y]) {
                check[x][y] = true;
                dp[x][y] = true;
                int number = map[x][y];
                dfs(x + 1, y, number);
                dfs(x - 1, y, number);
                dfs(x, y + 1, number);
                dfs(x, y - 1, number);
                check[x][y] = false;
            }
        }
    }
}
