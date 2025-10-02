package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p9663_2 {

    static int n;
    static boolean[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        backtrack(0);

        System.out.println(count);
    }

    //depth가 최종적으로 n과 같아지면 마무리 왜냐? 가로줄이 선택이 다 된거니까
    private static void backtrack(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!map[depth][i]){
                //공격 불가능한 곳인지 확인
                if(!isAttackAvailable(depth, i)){
                    map[depth][i] = true;
                    backtrack(depth + 1);
                    map[depth][i] = false;
                }
            }
        }
    }

    private static boolean isAttackAvailable(int row, int col){

        //세로
        for(int i = row-1; i >= 0; i--){
            if(map[i][col]){
                return true;
            }
        }

        //상대각
        for(int i = 0; i < n; i++){
            if(row - i >= 0 && col + i < n) {
                if(map[row - i][col + i]){
                    return true;
                }
            }
        }

        //하대각
        for(int i = 0; i < n; i++){
            if(row - i >= 0 && col - i >= 0){
                if(map[row - i][col - i]){
                    return true;
                }
            }
        }

        return false;
    }

}
