package Baekjoon.bronze;

import java.util.*;
import java.io.*;
public class p20254 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c, d;
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        System.out.println(56*a + 24*b + 14*c + 6*d);

    }
}
