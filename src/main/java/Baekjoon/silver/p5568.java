package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p5568 {
    static int n;
    static int k;
    static boolean[] visited;
    static String[] a;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        a = new String[n];
        for(int i = 0; i < n; i++){
            a[i] = br.readLine();
        }

        recur(0, new StringBuilder());

        System.out.println(set.size());

    }

    private static void recur(int count, StringBuilder sb){
        if(count == k) {
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                visited[i] = true;
                recur(count + 1, new StringBuilder(sb + a[i]));
                visited[i] = false;
            }
        }


    }


}
