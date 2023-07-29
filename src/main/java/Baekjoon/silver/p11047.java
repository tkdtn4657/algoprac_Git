package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }


        while(k > 0){
            for(int i = a.length-1; i >= 0; i--){
                if(k >= a[i]){
                    count += k/a[i];
                    k = k % a[i];
                }
            }
        }
        System.out.println(count);
    }
}
