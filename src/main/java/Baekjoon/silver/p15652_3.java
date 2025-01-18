package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15652_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        recur(1, m, "", n, 0, sb);

        System.out.println(sb);
    }

    public static void recur(int num, int m, String s, int n, int count, StringBuilder sb) {
        if(count == m){
            sb.append(s).append("\n");
            return;
        }

        for(int i = num; i <= n; i++){
            if(count == 0){
                recur(i, m, "" + i, n, count+1, sb);
            } else {
                recur(i, m, s + " " + i, n, count+1, sb);
            }

        }
    }
}
