package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p985_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int q = Integer.parseInt(br.readLine());
        int mode;
        //mode1

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {//1번연산
                int j = Integer.parseInt(st.nextToken());
                int temp = a[j - 1][n - 1];
                for (int g = n - 1; g >= 1; g--) {
                    a[j-1][g] = a[j-1][g - 1];
                }
                a[j-1][0] = temp;
            } else {
                //nextToekn은 더 없고 2번연산시작
                int[][] tempArray = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int g = 0; g < n; g++) {
                        tempArray[g][n - j - 1] = a[j][g];
                    }
                }
                a = tempArray;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    sb.append(a[i][j]);
                } else {
                    sb.append(a[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
