package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1937 {

    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                max = Integer.max(recur(y,x), max);
            }
        }

        System.out.println(max+1);
    }

    private static int recur(int y, int x){

        if(dp[y][x] != 0) return dp[y][x];

        int dy;
        int dx;
        for(int[] move: moves){
            dy = y + move[0];
            dx = x + move[1];

            if( dy < 0 || dy >= n || dx < 0 || dx >= n ) continue;

            if(map[y][x] < map[dy][dx]){
                dp[y][x] = Integer.max(recur(dy,dx) + 1, dp[y][x]);
            }
        }
        return dp[y][x];
    }

}
