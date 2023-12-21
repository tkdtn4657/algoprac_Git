package Baekjoon.silver;

import java.io.*;
import java.util.*;

class p15652_2{

    static int[] a;
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = i;
        }

        backtrack(0,0, "");

        System.out.println(sb);

    }

    static void backtrack(int num, int depth, String s){
        if(depth == m){
            sb.append(s).append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(i >= num) {
                String nowString = s;
                backtrack(i,depth + 1, nowString.concat(String.valueOf(a[i])).concat(" "));
            }
        }


    }

}