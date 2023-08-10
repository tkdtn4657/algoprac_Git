package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2468 {
    static int[][] map;
    static boolean[][] check;
    static int n;
    static int count;
    static final int[][] mapXY = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] checkcheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
//        check = new boolean[n][n];
        int maxHeight = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                maxHeight = Integer.max(num, maxHeight);
                map[i][j] = num;
            }
        }

        int maxCountArea = 0;
        for (int h = maxHeight; h >= 0; h--) {
            count = 0;
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        dfs(i, j, h);
                    }
                }
            }
            checkcheck = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!checkcheck[i][j] && !check[i][j]) {
                        checkArea(i, j);
                        count++;
                    }
                }
            }


            maxCountArea = Integer.max(maxCountArea, count);
        }

        System.out.println(maxCountArea);


    }

    static void dfs(int x, int y, int height) {
        if (x < n && x >= 0 && y < n && y >= 0 && height >= map[x][y]) {
            if (!check[x][y]) {
                check[x][y] = true;
                for (int[] a : mapXY) {
                    int[] now = {x + a[0], y + a[1]};
                    dfs(now[0], now[1], height);
                }
            }
        }
    }

    static void checkArea(int x, int y) {
        if (x < n && x >= 0 && y < n && y >= 0) {
            if (!checkcheck[x][y] && !check[x][y]) {
                checkcheck[x][y] = true;
                for (int[] a : mapXY) {
                    int[] now = {x + a[0], y + a[1]};
                    checkArea(now[0], now[1]);
                }
            }
        }
    }
}