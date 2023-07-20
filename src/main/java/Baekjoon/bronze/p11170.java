package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p11170 {
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            countZero(n, m);
        }
    }

    static void countZero(int n, int m){
        count = 0;
        String temp;
        for(int i = n; i < m+1; i++){
            temp = String.valueOf(i);
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j)-'0' == 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
