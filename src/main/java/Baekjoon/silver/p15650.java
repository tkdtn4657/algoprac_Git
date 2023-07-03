package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15650 {

    static boolean check[];
    static ArrayList<String> sl = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];

        backTrack("", 0, new ArrayList<Integer>());

        StringBuilder sb = new StringBuilder(16*16+9);
        for (String s : sl) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void backTrack(String s, int count, ArrayList<Integer> test) {
        ArrayList<Integer> temp = (ArrayList<Integer>) test.clone();
        if (count == m) {
            sl.add(s);
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!temp.contains(i)) {
                temp.add(i);
                if (count == 0) backTrack(String.valueOf(i), count + 1, temp);
                else backTrack(s + " " +i, count + 1, temp);
            }
        }
    }
}