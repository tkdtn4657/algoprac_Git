package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p14656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            if(a[i] != i+1){
                count++;
            }
        }

        System.out.println(count);

    }
}
