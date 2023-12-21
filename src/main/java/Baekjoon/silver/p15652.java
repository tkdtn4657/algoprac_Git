package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15652 {
    static int n, m;
    static boolean[] check;
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        check = new boolean[n+1];


        backTrack("", 0, 0);

        for(String s : al) {
            System.out.println(s);
        }
    }

    static void backTrack(String s, int count, int prevNum){
        if(count == m){
            al.add(s);
            check = new boolean[n+1];
            return;
        }

//        ArrayList<Integer> check = new ArrayList<>();

        for(int i = 1; i < n+1; i++){
            if(!check[i]){
                backTrack(s + " " + i, count+1, i);
            }
        }

        check[prevNum] = true;

    }
}
