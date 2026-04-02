package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int four = Integer.parseInt(st.nextToken());

            int start = one * 100 + two;
            int end = three * 100 + four;

            a[i][0] = start;
            a[i][1] = end;
        }

        Arrays.sort(a, (o1, o2) -> {

            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];

        });

        int cur = 301;
        int target = 1201;
        int idx = 0;
        int count = 0;

        while (cur < target) {
            int next = cur;

            while (idx < n && a[idx][0] <= cur) {
                next = Math.max(next, a[idx][1]);
                idx++;
            }

            if (next == cur) {
                System.out.println(0);
                return;
            }

            cur = next;
            count++;
        }

        System.out.println(count);
    }
}
