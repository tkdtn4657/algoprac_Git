package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p26082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(a[1] / a[0] * a[2] * 3);
    }
}
