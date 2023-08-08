package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p10989 {
    static int[] a;
    static long result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        for(int i = 0; i < n; i++ ){
            a[i] = Integer.parseInt(br.readLine());
        }

        radix_sort(a, 5);//10000보다 작거나 같기 때문에
        //출력

        StringBuilder sb = new StringBuilder();
        for(int num : a){
            sb.append(num).append("\n");
        }
        System.out.println(sb);

    }
    static void radix_sort(int[] a, int max){
        int[] output = new int[a.length];
        int jari = 1;
        int count = 0;
        while(count != max){
            int[] bucket = new int[10];
            for(int i = 0; i < a.length; i++){
                bucket[(a[i]/jari) % 10]++;
            }
            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }
            for(int i = a.length - 1; i >= 0; i--){
                output[bucket[(a[i]/jari % 10)] - 1] = a[i];
                bucket[(a[i]/jari) % 10]--;
            }
            for(int i = 0; i < a.length; i++){
                a[i] = output[i];
            }
            jari = jari * 10;
            count++;
        }
    }
}
