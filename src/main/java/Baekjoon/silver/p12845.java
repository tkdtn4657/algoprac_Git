package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p12845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        int max = 0;
        int maxIndex = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            if(a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            if(maxIndex != i){
                result += a[i] + max;
            }
        }

        System.out.println(result);

    }
}
