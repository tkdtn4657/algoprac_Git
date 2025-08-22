package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2447 {
    static int n;
    static Character[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new Character[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '*';
            }
        }
        //분할 정복을 해보자
        recur(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    /**
     * recur(x, y, n) => recur(x, y, n/3) * 8
     * */
    private static void recur(int x, int y, int length){
        if(length == 1){
            return;
        }

        int divideNum = length/3;
        for(int i = x+divideNum; i < x+divideNum*2; i++){
            for(int j = y+divideNum; j < y+divideNum*2; j++){
                map[i][j] = ' ';
            }
        }

        for(int i = x; i < x+length; i += divideNum){
            for(int j = y; j < y+length; j += divideNum){
                recur(i, j, divideNum);
            }
        }

    }
}
