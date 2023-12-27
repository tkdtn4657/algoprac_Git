package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p15059 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a1 = new int[3];
        int[] a2 = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            a1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            a2[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < 3; i++){
            if(a2[i] > a1[i]){
                sum += a2[i]-a1[i];
            }
        }
        System.out.println(sum);
    }
}
