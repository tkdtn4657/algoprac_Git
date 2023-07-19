package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1085_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cats = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cats[i] = Integer.parseInt(st.nextToken());
        }
        boolean check[] = new boolean[n];
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(i+j <= k && !check[i] && !check[j]){
                        check[i] = true;
                        check[j] = true;
                        count++;
                    }
                }
            }
            max = Integer.max(max, count);
        }
        System.out.println(max);
    }
}
