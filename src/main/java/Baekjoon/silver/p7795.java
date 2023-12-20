package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

//            int aPoint = 0;
            int aPoint = 0;
            int bPoint = 0;
            //1 1 3 7 8
            //1 3 6
            int count = 0;
            //자기를 넘기는 수를 인덱스화 n-aPoint가 갯수 자신을 먹는 a들의 수
            while (bPoint < m && aPoint < n) {
                if (b[bPoint] >= a[aPoint]) {
                    aPoint++;
                } else {
                    count += n - aPoint;
                    bPoint++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
