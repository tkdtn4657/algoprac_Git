package Programmers.lv2;

import java.io.*;
import java.util.*;

class p1844 {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }

    //[[1,0,1,1,1],
    //[1,0,1,0,1],
    //[1,0,1,1,1],
    //[1,1,1,0,1],
    //[0,0,0,0,1]]
    static int[][] map;
    static int[][] distance;
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int count = 0;
    static int n = 0;
    static int m = 0;

    static boolean flag = false;

    public static int solution(int[][] maps) {
        //x = n, y = m
        map = maps;
        n = maps.length;
        m = maps[0].length;
        distance = new int[m][n];

        // bfs(0, 0);
        dfs(0, 0);

        if (flag) {
            // bfs -> return map[n-1][m-1]-1;
            return distance[n - 1][m - 1];
            //dfs -> distance[n-1][m-1];
        } else {
            return -1;
        }

    }

    static void dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            flag = true;
            return;
        }

        if (x == 0 && y == 0) {
            distance[x][y] = 1;
        }
        for (int[] move : move) {
            int nowX = x + move[0];
            int nowY = y + move[1];
            if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m &&
                    map[nowX][nowY] == 1 && distance[nowX][nowY] == 0) {
                distance[nowX][nowY] = distance[x][y] + 1;
                dfs(nowX, nowY);
            }
        }


    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[x][y] = 2;
        while (!queue.isEmpty()) {
            count++;
            int[] nowXY = queue.poll();
            for (int[] move : move) {
                int nowX = nowXY[0] + move[0];
                int nowY = nowXY[1] + move[1];
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m &&
                        map[nowX][nowY] == 1) {
                    if (nowX == n - 1 && nowY == m - 1) {
                        flag = true;
                        map[nowX][nowY] = map[nowXY[0]][nowXY[1]] + 1;
                        return;
                    }
                    queue.add(new int[]{nowX, nowY});
                    map[nowX][nowY] = map[nowXY[0]][nowXY[1]] + 1;
                }
            }
        }
    }
}

