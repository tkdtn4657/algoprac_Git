package Baekjoon.Compatition.KookminAndChungAng_openContest;

import java.io.*;
import java.util.*;

public class p1100_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int max = 0;
        for(int num : a){
            if(num == 0){
                max = Integer.max(count, max);
                count = 0;
                continue;
            }
            count++;
        }
        max = Integer.max(count, max);
        System.out.println(max);
    }
}
