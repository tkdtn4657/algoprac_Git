package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];



        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        //누적합 구하기
        int sum[] = new int[n];
        sum[0] = a[0];
        for(int i = 1; i <n; i++){
            sum[i] = sum[i-1] + a[i];
        }
        //누적합 끝

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j){
                    if(a[i] == m) count++;
                }
                else if(count(i, j, m, sum)) count++;
            }
        }
        for(int i = 0; i < n; i++){

        }

        System.out.println(count);
    }

    static boolean count(int left, int right, int m, int[] a){
        int sum =0;
        if(left > 0){
            sum = a[right] - a[left-1];
        }else{
            sum = a[right];
        }

        if(sum == m) return true;
        return false;
    }
}
