package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, n) - 1).append(System.lineSeparator());

        hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int to) {
        if(n == 1) {
            sb.append(start).append(" ").append(to).append(System.lineSeparator());
            return;
        }
        //A -> B
        hanoi(n-1, start, to, mid);

        sb.append(start).append(" ").append(to).append(System.lineSeparator());

        //B -> C
        hanoi(n-1, mid, start, to);
    }
}
