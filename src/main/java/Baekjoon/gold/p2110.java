package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }


        //거리가 center
        //5 3
        //1 2 8 4 9
        //sort -> 1 2 4 8 9
        //1 1 2 4 5
        //1 2 4 8 13
        //공유기는 3대
        //1 ~ 9까지의 수에서 3대 거리를 자르면 됨 대신 집이 있어야함
        //결국엔 정렬해서 3을 넘으면 자르면 될듯?

        Arrays.sort(a);
        int[] aLength = a.clone();

        //2 5
        //2 3
        for (int i = n - 1; i >= 1; i--) {
            aLength[i] = aLength[i] - aLength[i - 1];
        }

        int left = a[0];
        int right = a[n - 1];
        int result = Integer.MIN_VALUE;
        while (left <= right) {
            //depth 1 : 5
            //1 2 | 4 |8 |9
            int center = (left + right) / 2;
            int length = 0;
            int lengthCount = 1;
            int minLength = Integer.MAX_VALUE;
            //1 1 2 4 5
            //1 2 4 8 13
            for (int i = 1; i < n; i++) {
                if (length <= center) {
                    minLength = Integer.min(minLength, length-aLength[i-1]);
                    length = aLength[i];
                    lengthCount++;
                } else {
                    length += aLength[i];
                }
            }
            minLength = Integer.min(minLength, length);

            if (lengthCount <= c) {
                result = Integer.max(minLength, result);
                right = center - 1;
            } else {
                left = center + 1;
            }
        }

        System.out.println(result);

    }
}
