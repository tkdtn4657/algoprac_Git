package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p11559 {
    static final int[][] movePoint = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited = new boolean[12][6];
    static char[][] puyoMap = new char[12][6];
    static int count = 0;
    static int n = 12;
    static boolean puyoClear = false;
    static ArrayList<int[]> accumulatePuyoMap = new ArrayList<>();
    static ArrayList<int[]> clearPuyoMap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            puyoMap[i] = br.readLine().toCharArray();
        }

        do {
            puyoClear = false;
            puyoGame();
            if (puyoClear) {
                count++;
                puyoMove();
            }
            clearPuyoMap.clear();
            visited = new boolean[12][6];
        } while (puyoClear);
        System.out.println(count);

    }

    static void puyoGame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                if (puyoMap[i][j] != '.' && !visited[i][j]) {
                    bfs(i, j, puyoMap[i][j]);
                }
            }
        }
    }

    static void bfs(int x, int y, char puyoColor) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        accumulatePuyoMap.clear();
        accumulatePuyoMap.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] nowXY = q.poll();
            for (int[] moveXY : movePoint) {
                int nowX = nowXY[0] + moveXY[0];
                int nowY = nowXY[1] + moveXY[1];
                if (nowX >= 0 && nowY >= 0 &&
                        nowX < 12 && nowY < 6 &&
                        puyoColor == puyoMap[nowX][nowY] &&
                        !visited[nowX][nowY]) {
                    visited[nowX][nowY] = true;
                    q.add(new int[]{nowX, nowY});
                    accumulatePuyoMap.add(new int[]{nowX, nowY});
                }
            }
        }
        if (accumulatePuyoMap.size() >= 4) {
            puyoClear = true;
            clearPuyoMap.addAll(accumulatePuyoMap);
        }
    }

    static void puyoMove() {
        //4개 이상인 뿌요를 .으로 초기화
        for (int[] clearXY : clearPuyoMap) {
            puyoMap[clearXY[0]][clearXY[1]] = '.';
        }

        //.을 탐색하며 뿌요를 위로 올려줌
        int[] firstDotPlace = new int[2];
        for (int i = 0; i < 6; i++) {
            boolean firstDotCheck = false;
            Queue<Character> upMovePuyo = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (puyoMap[j][i] == '.') {
                    if (firstDotCheck) {
                        continue;
                    }
                    firstDotPlace[0] = j;
                    firstDotPlace[1] = i;
                    firstDotCheck = true;
                } else if (firstDotCheck) {
                    upMovePuyo.add(puyoMap[j][i]);
                    puyoMap[j][i] = '.';
                }
            }
            int nowX = firstDotPlace[0];
            int nowY = firstDotPlace[1];
            while (!upMovePuyo.isEmpty()) {
                puyoMap[nowX][nowY] = upMovePuyo.poll();
                nowX--;
            }
        }
    }
}
