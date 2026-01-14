package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long[] sumArray = new long[n];
        sumArray[0] = a[0];
        for (int i = 1; i < n; i++) sumArray[i] = sumArray[i - 1] + a[i];
        long total = sumArray[n - 1];

        long sum = 0;

        // 1) 벌(0) - 벌(i) - 꿀통(n-1)
        for (int i = 1; i <= n - 2; i++) {
            long bee1 = total - a[0] - a[i];
            long bee2 = total - sumArray[i];
            sum = Math.max(sum, bee1 + bee2);
        }

        // 2) 꿀통(0) - 벌(i) - 벌(n-1)
        for (int i = 1; i <= n - 2; i++) {
            long bee1 = total - a[n - 1] - a[i];
            long bee2 = sumArray[i - 1];
            sum = Math.max(sum, bee1 + bee2);
        }

        // 3) 벌(0) - 꿀통(i) - 벌(n-1)
        for (int i = 1; i <= n - 2; i++) {
            long honeyMiddleSum = (total - a[0] - a[n - 1]) + a[i];
            sum = Math.max(sum, honeyMiddleSum);
        }

        System.out.println(sum);
    }
}
