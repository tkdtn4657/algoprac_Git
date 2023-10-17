package Baekjoon.silver;

import java.io.*;
import java.util.*;
public class p14729 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        float[] a = new float[n];

        for(int i = 0; i < n; i++){
            a[i] = Float.parseFloat(br.readLine());
        }

        Arrays.sort(a);

        for(int i = 0; i < 7; i++){
            System.out.printf("%.3f\n",a[i]);
        }
    }
}
