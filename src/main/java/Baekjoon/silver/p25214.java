package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 6
 * 50 100 70 110 10 100
 *
 * 6개의 배열에서 index i, j에서 a[j] - a[i]의 최댓값
 * 이후 7개로바뀌면 그중에서 해당 조건의 최댓값
 * 그냥 구현하면될거같은데?
 * 200000!
 *
 * dp?
 *
 * 20만이면 엄청많이돌아야할거같은데...
 *
 * dp일 필요 없이 이전 조건을 포함시키면 될거같음
 * 이전조건에 추가된거에서 플러스해서체크하는느낌..?
 *
 * 20
 *
 *
 * 맥스라면 변경
 * 50 100 70 110 10 100
 * 0 50 50 60 60 90
 */
public class p25214 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] dp = new int[n];
        int[] minArray = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        minArray[0] = a[0];
        for(int i = 1; i < n; i++) {
            minArray[i] = Integer.min(a[i], minArray[i-1]);
        }

        dp[0] = 0;
        int min = 0;

        for(int i = 1; i < n; i++){
            dp[i] = Integer.max(dp[i-1], a[i] - minArray[i-1]);
        }

        for(int num : dp){
            System.out.print( num + " ");
        }

    }

}
