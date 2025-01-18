package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15651_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        recur(n, m, "", sb, 0);

        System.out.println(sb);
    }

    public static void recur(int n, int m, String s, StringBuilder sb, int count) {
        if(count == m) {
            sb.append(s).append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(count == 0){
                recur(n, m, "" + i, sb, count + 1);
            } else {
                recur(n, m, s + " " + i, sb, count + 1);
            }
        }

    }
}
