package Baekjoon.bronze;

import java.io.*;


public class p2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        bubble(a);

        StringBuilder sb = new StringBuilder();
        for(int num : a){
            sb.append(num).append("\n");
        }

        System.out.println(sb);

    }

    static void bubble(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
