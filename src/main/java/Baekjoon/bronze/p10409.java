package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            if (sum <= m) {
                count++;
            } else {
                System.out.println(count);
                return;
            }
        }
        System.out.println(count);
    }
}
