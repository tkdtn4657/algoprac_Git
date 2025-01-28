package Baekjoon.gold;

import java.io.*;
import java.util.*;

//누적합 개똥벌레
public class p3020_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[h + 2]; // h + 2 크기 배열 (경계 처리를 위해 +1 추가)

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) { // 석순
                prefixSum[1]++;
                prefixSum[num + 1]--;
            } else { // 종유석
                prefixSum[h - num + 1]++;
                prefixSum[h + 1]--;
            }
        }

        // 누적합 계산
        for (int i = 1; i <= h; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        // 최소값 및 카운트 계산
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            if (prefixSum[i] < min) {
                min = prefixSum[i];
                count = 1;
            } else if (prefixSum[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
