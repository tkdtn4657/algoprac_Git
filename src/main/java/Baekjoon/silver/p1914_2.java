package Baekjoon.silver;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class p1914_2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2");

        System.out.println(count.pow(n).subtract(new BigInteger("1")));
        if (n > 20) {
            return;
        }

        hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }

    static void hanoi(int n, int from, int center, int end) {
        if (n == 1) {
            sb.append(from).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n - 1, from, end, center);
        sb.append(from).append(" ").append(end).append("\n");
        hanoi(n - 1, center, from, end);

    }

}