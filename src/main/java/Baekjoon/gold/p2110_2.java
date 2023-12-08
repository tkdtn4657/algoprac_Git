package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2110_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);
        int[] aLength = a.clone();
        for (int i = 1; i < n; i++) {
            aLength[i] = a[i] - a[i - 1];
        }

        //공유기 사이의 거리 center 즉 a의 요소의 최댓값
        long left = 1;
        long right = a[n - 1]-a[0];
        long result = Integer.MAX_VALUE;
        long check = 0;
        while (left <= right) {
            long divide = 1;
            long center = (left + right) / 2;
            long place = a[0];
            for (int i = 0; i < n; i++) {
                check = a[i] - place;
                if (check >= center) {
                    divide++;
                    place = a[i];
                }
            }
            /**
             * 1 1 2 4 1
             * center는 두 공유기 사이의 거리로 잡혀있고
             * left 1, right 9
             * 5 차이나는 카운트가 2개
             * 거리를 늘려야 c에 맞음
             *
             *
             */
            if (divide >= c) {//거리가 더 좁아져야함 사이의 거리가 너무 적단건데????
                left = center + 1;
                result = center;
            } else {
                right = center -1;
            }
        }
        System.out.println(result);
    }
}
