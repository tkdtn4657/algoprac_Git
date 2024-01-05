package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (!set.add(a[i][j])) {
                    System.out.println("FALSE");
                    return;
                }
            }
        }

        int sumCheck = n * (n * n + 1) / 2;
        //가로체크
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
            }
            if (sum != sumCheck) {
                System.out.println("FALSE");
                return;
            }
        }

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][j];
            }
            if (sum != sumCheck) {
                System.out.println("FALSE");
                return;
            }
        }

        //대각체크
        int sum = 0;
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            sum += a[i++][j];
        }
        if (sum != sumCheck) {
            System.out.println("FALSE");
            return;
        }

        i = 0;
        int j = 0;
        sum = 0;
        for (i = 0; i < n; i++) {
            sum += a[i][i];
        }
        if (sum != sumCheck) {
            System.out.println("FALSE");
            return;
        }


        System.out.println("TRUE");

    }
}
