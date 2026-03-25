package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 50 14
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
 * <p>
 * 답: 105
 * <p>
 * <p>
 * <p>
 * 50 1
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
 * <p>
 * 답: 1275
 * <p>
 * <p>
 * <p>
 * 50 3
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
 * <p>
 * 답: 435
 * <p>
 * <p>
 * <p>
 * 50 50
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
 * <p>
 * 답: 50
 */
public class p2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            max += a[i];
        }
        if(m == 1){
            System.out.println(max);
            return;
        }

        long left = 1;
        long right = max;

        long maxLength = 0;

        //center는 블루레이 길이의 평균값
        //m개로 자르기
        while (left <= right) {
            long length = 0;
            int blueRayCount = 1;
            long center = (left + right) / 2;
            long blueRayMax = 0;
            for (int i = 0; i < n; i++) {
                length += a[i];
                if (length >= center) {
                    blueRayMax = Long.max(length - a[i], blueRayMax);
                    length = a[i];
                    blueRayCount++;
                }
            }
            blueRayMax = Long.max(length, blueRayMax);
            if (blueRayCount > m) {
                left = center + 1;
            } else {

                maxLength = blueRayMax;
                right = center - 1;
            }
        }
        System.out.println(maxLength);
    }
}
