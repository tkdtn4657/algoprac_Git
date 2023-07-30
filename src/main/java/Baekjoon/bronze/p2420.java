package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p2420 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        System.out.println(Math.abs(n-m));

    }
}
