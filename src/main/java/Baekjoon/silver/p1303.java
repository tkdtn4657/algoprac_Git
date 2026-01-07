package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1303 {

    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //White, Blue
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[m][n];

        char[][] warPlace = new char[m][n];
        for(int i = 0; i < m; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < n; j++){
                char soldier = inputLine.charAt(j);
                warPlace[i][j] = soldier;
            }
        }

        int wScore = 0;
        int bScore = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    char nowSoldierTeam = warPlace[i][j];
                    int score = bfs(nowSoldierTeam, i, j, visited, warPlace, n, m);

                    if(nowSoldierTeam == 'W'){
                        wScore += score;
                    } else {
                        bScore += score;
                    }
                }
            }
        }

        System.out.println(wScore + " " + bScore);

    }

    private static int bfs(char nowTeam, int i, int j, boolean[][] visited, char[][] warPlace, int n, int m){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int[] nowPlace = queue.poll();
            for(int[] move :moves){
                int dx = nowPlace[0] + move[0];
                int dy = nowPlace[1] + move[1];

                if(dx < 0 || dy < 0 || dx >= m || dy >= n) continue;

                if(!visited[dx][dy] && warPlace[dx][dy] == nowTeam) {
                    visited[dx][dy] = true;
                    count++;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        return count * count;


    }
}
