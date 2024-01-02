package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p8710 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = (b - a + c - 1) / c;

        System.out.println(result);
    }
}