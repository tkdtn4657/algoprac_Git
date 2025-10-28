package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long max = a[i][0] + (a[i][1] * (a[i][2]-1));
            if(max < t) continue;
            long sum = a[i][0];
            if(sum >= t) {
                min = Long.min(min, sum-t);
                continue;
            }
            for(int j = 1; j < a[i][2]; j++){
                sum += a[i][1];
                if(sum >= t) break;
            }
            min = Long.min(min, sum-t);
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
