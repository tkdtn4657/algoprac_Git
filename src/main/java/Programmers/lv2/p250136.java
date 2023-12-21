package Programmers.lv2;

import java.io.*;
import java.util.*;

public class p250136 {

    public static void main(String[] args) {
        //[[0, 0, 0, 1, 1, 1, 0, 0],
        // [0, 0, 0, 0, 1, 1, 0, 0],
        // [1, 1, 0, 0, 0, 1, 1, 0],
        // [1, 1, 1, 0, 0, 0, 0, 0],
        // [1, 1, 1, 0, 0, 0, 1, 1]]
//        int[][] land = new int[5][8];

//        land[0] = new int[]{0, 0, 0, 1, 1, 1, 0, 0};
//        land[1] = new int[]{0, 0, 0, 0, 1, 1, 0, 0};
//        land[2] = new int[]{1, 1, 0, 0, 0, 1, 1, 0};
//        land[3] = new int[]{1, 1, 1, 0, 0, 0, 0, 0};
//        land[4] = new int[]{1, 1, 1, 0, 0, 0, 1, 1};

        //[[1, 0, 1, 0, 1, 1],
        // [1, 0, 1, 0, 0, 0],
        // [1, 0, 1, 0, 0, 1],
        // [1, 0, 0, 1, 0, 0],
        // [1, 0, 0, 1, 0, 1],
        // [1, 0, 0, 0, 0, 0],
        // [1, 1, 1, 1, 1, 1]]
        int[][] land = new int[7][6];

        land[0] = new int[]{1, 0, 1, 0, 1, 1};
        land[1] = new int[]{1, 0, 1, 0, 0, 0};
        land[2] = new int[]{1, 0, 1, 0, 0, 1};
        land[3] = new int[]{1, 0, 0, 1, 0, 0};
        land[4] = new int[]{1, 0, 0, 1, 0, 1};
        land[5] = new int[]{1, 0, 0, 0, 0, 0};
        land[6] = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(solution(land));
    }

    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    static int count = 5;
    static int[][] map;
    static Set<Integer> set = new HashSet<>();
    static Map<Integer, Integer> numberMap = new HashMap<>();

    public static int solution(int[][] land) {
        int max = Integer.MIN_VALUE;
        map = land;
        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (map[j][i] == 1) {
                    bfs(j, i, count++);
                }
            }
        }

        for(int i = 0; i < land[0].length; i++){
            set = new HashSet<>();
            for(int j = 0; j < land.length; j++){
                if(map[j][i] != 0){
                    set.add(map[j][i]);
                }
            }
            if(!numberMap.isEmpty()) {
                int sum = 0;
                for (int num : set) {
                    sum += numberMap.get(num);
                }
                max = Integer.max(max, sum);
            }
        }

        return max;
    }

    static void bfs(int x, int y, int number) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = number;
        count++;

        while (!q.isEmpty()) {
            int[] nowXY = q.poll();

            for (int[] move : move) {
                int tempX = nowXY[0] + move[0];
                int tempY = nowXY[1] + move[1];
                if (tempX >= 0 && tempX < map.length && tempY >= 0 && tempY < map[0].length &&
                        map[tempX][tempY] == 1) {
                    map[tempX][tempY] = number;
                    count++;
                    q.add(new int[]{tempX, tempY});
                }
            }
        }

        numberMap.put(number, count);
    }
}

