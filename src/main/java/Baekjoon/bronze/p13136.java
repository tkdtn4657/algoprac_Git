package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        long num = r / n;
        long nmg = r % n;

        long count = 0;
        if(nmg == 0) {
            count = num;
        }else {
            count = num + 1;
        }

        num = c / n;
        nmg = c % n;

        if(nmg == 0) {
            count = num * count;
        }else {
            count = (num + 1) * count;
        }

        System.out.println(count);
    }
}
