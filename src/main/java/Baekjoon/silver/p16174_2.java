package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16174_2 {

    static int[][] map;
    static boolean[][] visited;
    static int n;

    static boolean gameEnd = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(st.nextToken()));
            }
        }

        dfs(0, 0);

        if(gameEnd){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }
    static void dfs(int x, int y){
        if(x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
            visited[x][y] = true;

            if(map[x][y] == -1){
                gameEnd = true;
                return;
            }

            int plusData = map[x][y];
            dfs(x + plusData, y);
            dfs(x - plusData, y);
            dfs(x, y + plusData);
            dfs(x, y - plusData);
        }
    }
}
