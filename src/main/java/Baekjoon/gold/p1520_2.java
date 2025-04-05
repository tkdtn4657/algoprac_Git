package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1520_2 {

    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static int[][] dp;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = recur(0, 0);

        System.out.println(result);

    }

    private static int recur(int y, int x){

        if(y == m-1 && x == n-1) return 1;

        if(dp[y][x] != -1) return dp[y][x];

        int dy;
        int dx;

        int count = 0;
        for(int[] move : moves){
            dy = y + move[0];
            dx = x + move[1];

            if(dy < 0 || dx < 0 || dy >= m || dx >= n) continue;
            if(map[y][x] > map[dy][dx]){
                count += recur(dy, dx);
            }
        }

        return dp[y][x] = count;
    }
}
