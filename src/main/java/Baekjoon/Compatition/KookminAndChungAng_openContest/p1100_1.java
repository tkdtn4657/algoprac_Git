package Baekjoon.Compatition.KookminAndChungAng_openContest;

import java.io.*;
import java.util.*;
public class p1100_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        float w = Float.parseFloat(st.nextToken());
        float h = Float.parseFloat(st.nextToken());

        System.out.println(String.format( "%.1f", (w * h) / 2));


    }
}
