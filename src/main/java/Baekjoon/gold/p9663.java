package Baekjoon.gold;

import java.io.*;

public class p9663 {

    static int n;
    static int count = 0;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        backtrack(0);

        System.out.println(count);
    }

    private static void backtrack(int row){
        if(row == n){
            count++;
            return;
        }

        for(int col = 0; col < n; col++){
            if(isAttackAvailablePlace(row, col)){
                map[row][col] = true;
                backtrack(row + 1);
                map[row][col] = false;
            }
        }
    }

    private static boolean isAttackAvailablePlace(int row, int col) {

        //세로 공격
        for(int i = 0; i <= row; i++){
            if(map[i][col]){
                return false;
            }
        }

        //대각 공격
        for(int i = 0; i < n; i++){
            if(row - i >= 0 && col - i >= 0) {
                if (map[row - i][col - i]) {
                    return false;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(row - i >= 0 && col + i < n) {
                if (map[row - i][col + i]) {
                    return false;
                }
            }
        }

        return true;
    }
}