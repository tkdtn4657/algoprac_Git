package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long[] a = new long[101];

        a[0] = 1;
        a[1] = 1;
        a[2] = 1;

        for(int i = 3; i <= 100; i++){
            a[i] = a[i-2] + a[i-3];
        }

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append(a[n-1]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
