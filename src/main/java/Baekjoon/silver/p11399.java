package Baekjoon.silver;

import java.io.*;
import java.util.*;


public class p11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        boolean[] check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        int insertIndex = 0;
        for (int i = 1; i < n; i++) {
            temp = a[i];
            int j = i - 1;

            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }

        //1 2 3 3 4
        //1 3 6 9 13
        int result = 0;
        int[] sum = new int[n];
        sum[0] = a[0];
        for (int i = 1; i < n; i++){
            sum[i] = a[i]+sum[i-1];
        }
        for(int num : sum){
            result += num;
        }
        System.out.println(result);
    }
}
