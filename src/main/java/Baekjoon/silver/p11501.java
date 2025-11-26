package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] price = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0L;
            int maxPrice = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (price[i] > maxPrice) {
                    maxPrice = price[i];         //새로운 최고가
                } else {
                    //maxPrice에 팔 거라고 가정하고 산다
                    profit += (maxPrice - price[i]);
                }
            }

            sb.append(profit).append('\n');
        }

        System.out.print(sb);
    }
}
