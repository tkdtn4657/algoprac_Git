package Baekjoon.silver;

import java.util.*;
import java.io.*;
public class p15649 {

    static boolean[] check;
    static int n;
    static int m;
    static ArrayList<String> sl = new ArrayList<>();
    static int max;
    StringBuilder sb = new StringBuilder(64);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n+1];
        max = n;
        backTrack(0, "");

        StringBuilder sb = new StringBuilder();
        for(String s : sl){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static void backTrack(int n, String s){//종단점과 붙일 스트링
        if(n == m){
            sl.add(s);
            return;
        }

        for(int i = 1; i < max+1; i++){
            if(!check[i]){
                check[i] = true;
                if(n==0) backTrack(n+1, String.valueOf(i));
                else backTrack(n+1, s + " " + i);
                check[i] = false;
            }
        }
    }
}