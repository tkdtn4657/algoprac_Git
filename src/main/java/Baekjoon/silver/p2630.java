package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2630 {

    static int whiteCount = 0;
    static int blueCount = 0;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //n/2가 무조건 되는 정사각형 수 -> n은 128까지
        recur(n, 0, 0);

        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    static void recur(int sliceN, int start, int end){
        if(sliceN == 0){
            if(map[start][end] == 1){
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }

        if(start >= n && end >= n) {
            return;
        }
        int temp = map[start][end];
        boolean failFlag = false;
        out:
        for(int i = start; i < start+sliceN; i++){
            for(int j = end; j < end+sliceN; j++){
                if(i < n && j < n) {
                    if (map[i][j] != temp) {
                        failFlag = true;
                        //종이를 더 잘게 잘라야해
                        for (int g = 0; g < 2; g++) {
                            for(int k = 0; k < 2; k++) {
                                recur(sliceN / 2, start + g * sliceN / 2, end + k * sliceN / 2);
                            }
                        }
                        break out;
                    }
                }
            }
        }
        if(!failFlag){
            if (temp == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
        }
    }
}
