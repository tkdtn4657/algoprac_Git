package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p14500 {

    static int n;
    static int m;
    static int[][] a;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs도 아니고 브루트포스로 테트리미노 하나씩 체크해서 최댓값 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ㅡㅡㅡㅡ(i, j);
                ㅜ(i, j);
                ㄴ(i, j);
                ㅁ(i, j);
                ㄹ(i, j);
            }
        }

        System.out.println(max);

    }

    private static void ㅡㅡㅡㅡ(int i, int j){
        int sum = 0;
        if(j+3 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            sum += a[i][j+3];

            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+3 < n){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+2][j];
            sum += a[i+3][j];
            max = Integer.max(max, sum);
        }
    }

    private static void ㅜ(int i, int j){
        int sum = 0;
        if(j+2 < m && i+1 < n){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            sum += a[i+1][j+1];
            max = Integer.max(max, sum);
        }
        sum = 0;
        if(j+2 < m && i-1 >= 0){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            sum += a[i-1][j+1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        //ㅓ
        if(j-1 >= 0 && i+2 < n){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+1][j-1];
            sum += a[i+2][j];
            max = Integer.max(max, sum);
        }

        sum = 0;
        //ㅏ
        if(j+1 < m && i+2 < n){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+1][j+1];
            sum += a[i+2][j];
            max = Integer.max(max, sum);
        }
    }

    private static void ㄴ(int i, int j){
        int sum = 0;
        if(i+2 < n && j+1 < m){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+2][j];
            sum += a[i+2][j+1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i-1 >= 0 && j+2 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            sum += a[i-1][j+2];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+2 < n && j+1 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i+1][j+1];
            sum += a[i+2][j+1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+1 < n && j+2 < m){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+2 < n && j+1 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i+1][j];
            sum += a[i+2][j];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+2 < n && j-1 >= 0){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+2][j];
            sum += a[i+2][j-1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+1 < n && j+2 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i][j+2];
            sum += a[i+1][j+2];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+1 < n && j+2 < m){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+1][j+1];
            sum += a[i+1][j+2];
            max = Integer.max(max, sum);
        }
    }

    private static void ㅁ(int i, int j){
        int sum = 0;
        if(i+1 < n && j+1 < m){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i][j+1];
            sum += a[i+1][j+1];
            max = Integer.max(max, sum);
        }
    }

    private static void ㄹ(int i, int j){
        int sum = 0;
        if(i+2 < n && j+1 < m){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+1][j+1];
            sum += a[i+2][j+1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i-1 >= 0 && j+2 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i-1][j+1];
            sum += a[i-1][j+2];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+2 < n && j-1 >= 0){
            sum += a[i][j];
            sum += a[i+1][j];
            sum += a[i+1][j-1];
            sum += a[i+2][j-1];
            max = Integer.max(max, sum);
        }

        sum = 0;
        if(i+1 < n && j+2 < m){
            sum += a[i][j];
            sum += a[i][j+1];
            sum += a[i+1][j+1];
            sum += a[i+1][j+2];
            max = Integer.max(max, sum);
        }
    }
}
