package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12865_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] bag = new int[n][k+1];

        //w는 무게
        //v는 가치
        //무게가 적으면서 가치가 높은걸 담아야 함
        //i는 선택된 물건의 개수
        //j는 무게 기준 선택된 물건중 최적의 가치

        //bag[i][j] = Integer.max(bag[i-1][j]);
        //기본값 세팅
        for(int i = a[0][0]; i <= k; i++){
            bag[0][i] = a[0][1];
        }


        for(int i = 1; i < n; i++){

            int weight = a[i][0];
            int value = a[i][1];

            for(int j = 1; j <= k; j++){
                if(weight <= j){
                    bag[i][j] = Integer.max(bag[i-1][j], bag[i-1][j-weight] + value);
                }else {
                    bag[i][j] =bag[i-1][j];
                }
            }
        }
        System.out.println(bag[n-1][k]);
    }
}
