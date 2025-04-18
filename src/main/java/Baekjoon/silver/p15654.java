package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15654 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }

        Arrays.sort(array);
        check = new boolean[n];
        recur(0, "");

        System.out.println(sb);

    }

    private static void recur(int count, String s){
        if(count == m){
            sb.append(s).append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(check[i]){
                continue;
            }
            check[i] = true;
            if(count == 0){
                recur(count + 1, String.valueOf(array[i]));
            } else {
                recur(count + 1, s + " " + array[i]);
            }
            check[i] = false;
        }

    }
}
