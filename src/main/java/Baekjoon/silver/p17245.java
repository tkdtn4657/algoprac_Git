package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p17245 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long totalComputer = 0;
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                totalComputer += a[i][j];
            }
        }

        //절반 이상?
        //lowerbound
        //10_000_000를 기준으로 이분탐색
        long totalComputerMidLine = Math.round((double)(totalComputer)/2);
        int left = 0;
        int right = 10_000_000;
        int minute = 0;
        while(left <= right) {
            long count = 0;
            minute = (left + right) / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(a[i][j] == 0) continue;
                    if(minute <= a[i][j]) {
                        count += minute;
                    } else {
                        count += a[i][j];
                    }
                }
            }

            if(count >= totalComputerMidLine){
                right = minute - 1;
            } else {
                left = minute + 1;
            }
        }
        System.out.println(left);

    }
}
