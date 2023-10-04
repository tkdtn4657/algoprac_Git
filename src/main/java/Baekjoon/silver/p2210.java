package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2210 {

    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int n = 5;
    static int[][] map = new int[n][n];
    static boolean[][] visited = new boolean[n][n];

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, 0, String.valueOf(map[i][j]));
            }
        }

        System.out.println(set.size());
    }


    static void dfs(int x, int y, int length, String s) {
        if (length == 5) { // 0부터 시작해서 5까지문자를 붙이면 리턴
            set.add(s);
            return;
        }

        for (int[] moveEach : move) {
            int[] now = moveEach;
            int nowX = x + now[0];
            int nowY = y + now[1];

            if (nowX < n && nowY < n && nowX >= 0 && nowY >= 0) {
                dfs(nowX, nowY, length + 1, s + map[nowX][nowY]);
            }
        }
    }
}
