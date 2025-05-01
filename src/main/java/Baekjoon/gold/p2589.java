package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2589 {
    static int maxDistance = Integer.MIN_VALUE;

    static char[][] map;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        //50 * 50
        //2500 * 2500
        //6250000 할만한데?

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bfs(i, j);
                visited = new boolean[n][m];
            }
        }

        System.out.println(maxDistance-1);

    }

    private static void bfs(int x, int y){
        if(map[x][y] == 'W') return;
        visited[x][y] = true;
        int distance = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        ArrayList<Integer[]> al = new ArrayList<>();

        int nowX = x;
        int nowY = y;

        //next X, Y parsing/
        for(int[] move : moves){
            int dx = nowX + move[0];
            int dy = nowY + move[1];
            Integer[] nextMove = {dx, dy};
            queue.add(nextMove);
        }

        while(!queue.isEmpty()){
            distance++;
            for(Integer[] move : queue){
                int moveX = move[0];
                int moveY = move[1];

                if(
                        moveX < 0 || moveX >= n
                    || moveY < 0 || moveY >= m
                    || visited[moveX][moveY] || map[moveX][moveY] == 'W'
                ) continue;

                visited[moveX][moveY] = true;
                for( int[] moveXY : moves){
                    int nextX = moveX + moveXY[0];
                    int nextY = moveY + moveXY[1];
                    al.add(new Integer[]{nextX, nextY});
                }
            }

            queue.clear();

            if(!al.isEmpty()){
                queue.addAll(al);
                al.clear();
            }

        }

        maxDistance = Integer.max(maxDistance, distance);
    }

}
