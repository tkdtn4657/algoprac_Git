package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15651 {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backTrack("", 0);

        System.out.println(sb);
    }

    static void backTrack(String s, int count) {
        if (m == count) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (count == 0) backTrack(String.valueOf(i), count + 1);
            else backTrack(s + " " + i, count + 1);
        }
    }
}
