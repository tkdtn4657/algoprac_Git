package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        long max = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            max = Long.max(max, a[i]);
        }

        long start = 0;
        long end = max;

        while(start <= end){
            long mid = (start + end) / 2;
            long wood = 0;
            for(long tree : a){
                if(tree >= mid){
                    wood += tree - mid;
                }
            }
            if(wood >= m){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
