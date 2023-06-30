package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p26169 {
    static final int SIZE = 5;
    static int[][] map = new int[SIZE][SIZE];
//    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] check = new boolean[SIZE][SIZE];
    static boolean yami = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] start = new int[2];//출발지점

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        go(start[0], start[1], 0, 0);

        if(yami){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    static void go(int row, int col, int moveCount, int eatApple) {
        if(eatApple == 2) yami = true;
        if (moveCount == 4 || yami == true || row < 0 || col < 0
                || row >= SIZE || col >= SIZE || map[row][col] == -1) {//종료조건
            return;
        }

        if(!check[row][col]){
            if(map[row][col] == 1){
                eatApple++;
            }
            check[row][col] = true;
            go(row+1,col, moveCount+1, eatApple);
            go(row-1,col,moveCount+1,eatApple);
            go(row,col+1,moveCount+1,eatApple);
            go(row,col-1,moveCount+1,eatApple);
            check[row][col] = false;
        }
    }
}
