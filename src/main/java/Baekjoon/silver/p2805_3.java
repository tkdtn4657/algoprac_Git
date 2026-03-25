package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2805_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 2_000_000_000;
        int mid = left + (right - left) / 2;

        int max = Integer.MIN_VALUE;
        while(left < right){
            mid = left + (right - left) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++){
                if(a[i] > mid){
                    sum += a[i] - mid;
                }
            }

            if(sum >= m){
                left = mid + 1;
                max = Integer.max(max, mid);
            } else {
                right = mid;
            }

        }

        System.out.println(max);

    }
}
