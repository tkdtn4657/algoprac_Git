package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p14502 {

    static int max = Integer.MIN_VALUE;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        fillWall(map, 0);

        System.out.println(max);

    }

    private static int[][] arrayDeepCopy(int[][] map){
        int[][] copiedMap = new int[map.length][map[0].length];
        for(int i = 0; i < copiedMap.length; i++){
            for(int j = 0; j < copiedMap[i].length; j++){
                copiedMap[i][j] = map[i][j];
            }
        }
        return copiedMap;
    }

    private static void fillWall(int[][] map, int depth) {
        if(depth == 3){
            int[][] copiedMap = arrayDeepCopy(map);
            for(int i = 0; i < copiedMap.length; i++){
                for(int j = 0; j < copiedMap[i].length; j++){
                    if(map[i][j] == 2) {
                        virusFill(i, j, copiedMap);
                    }
                }
            }
            sumSafetyPlace(copiedMap);
            return;
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 0){
                    map[i][j] = 3;
                    fillWall(map, depth+1);
                    map[i][j] = 0;
                }
            }
        }


    }

    private static void virusFill(int i, int j, int[][] copiedMap) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] nowXY = queue.poll();
            for(int[] move : moves){
                int dx = nowXY[0] + move[0];
                int dy = nowXY[1] + move[1];

                if(dx < 0 || dy < 0 || dx >= copiedMap.length || dy >= copiedMap[0].length || copiedMap[dx][dy] != 0) continue;

                copiedMap[dx][dy] = 2;
                queue.add(new int[]{dx, dy});
            }
        }
    }

    private static void sumSafetyPlace(int[][] map) {
        int count = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        max = Integer.max(max, count);
    }
}
