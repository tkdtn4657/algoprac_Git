package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p18429 {

    static int n;
    static int k;
    static int[] a;
    static boolean[] visited;
    static int number = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 500);

        System.out.println(number);

    }

    private static void recur(int count, int muscles){
        if(count == n && muscles >= 500){
            number++;
            return;
        }
        if(muscles < 500) return;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                recur(count + 1, muscles- k + a[i]);
                visited[i] = false;
            }
        }
    }
}
