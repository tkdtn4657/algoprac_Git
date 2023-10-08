package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(st.nextToken());
        int a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(st.nextToken());
        int b = Integer.parseInt(sb.reverse().toString());

        if(a > b){
            System.out.println(a);
            return;
        }
        System.out.println(b);
    }
}
