package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15650_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        recur(1, m, 0,"" , sb, n);

        System.out.println(sb);
    }

    public static void recur(int num, int m, int count, String s, StringBuilder sb, int limit){
        if(count == m){
            sb.append(s).append("\n");
            return;
        }

        for(int i = num; i <= limit; i++){
            if(count == 0){
                recur(i + 1, m, count + 1, s + i, sb, limit);
            } else {
                recur(i + 1, m, count + 1, s + " " + i, sb, limit);
            }
        }

    }
}
