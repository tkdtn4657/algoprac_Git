package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2435 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = -2147483648;
        int sum;
        for(int i = 0; i < n-k+1; i++){
            sum = 0;
            int start = i;
            for(int j = 0; j < k; j++) {
                sum += a[start++];
            }
            max = Integer.max(max, sum);
        }

        System.out.println(max);

    }
}
