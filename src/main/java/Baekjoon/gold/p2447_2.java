package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2447_2 {

    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '*';
            }
        }

        for (int size = n; size > 1; size /= 3) {
            int step = size / 3;
            for (int x = 0; x < n; x += size) {
                for (int y = 0; y < n; y += size) {
                    draw(x + step, y + step, step);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void draw(int x, int y, int length){
        for(int i = x; i < x+length; i++){
            for(int j = y; j < y+length; j++){
                map[i][j] = ' ';
            }
        }
    }
}
