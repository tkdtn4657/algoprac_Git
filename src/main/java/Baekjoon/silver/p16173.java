package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16173 {

    static boolean[][] check;
    static int[][] square;
    static boolean haru = false;
    static int n;
//    static int[][] move = {{1, 0},{0, 1}};


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        square = new int[n][n];
        check = new boolean[n][n];
        StringTokenizer st;


        for(int i = 0; i < n;  i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                 square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i = 0; i < n;  i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(square[i][j] + " ");
//            }
//        }

        go(0,0);

        if(!haru){
            System.out.println("Hing");
        }else{
            System.out.println("HaruHaru");
        }
    }
    static void go(int x, int y){
        if(n <= x || n <= y){
            return;
        }
        if(square[x][y] == -1){ // 도착했을 때
            haru = true;
            return;
        }

        if(!check[x][y] && !haru) {
            int distance = square[x][y];
            check[x][y] = true;
            go(x+distance, y);
            go(x, y+distance);
            check[x][y] = false;
        }
    }
}
