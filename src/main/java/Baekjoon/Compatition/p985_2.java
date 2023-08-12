package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p985_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String now = br.readLine();
        int n = Integer.valueOf(br.readLine());
        String[] gifticon = new String[n];

        for (int i = 0; i < n; i++) {
            gifticon[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer nowSt = new StringTokenizer(now, "-");
            StringTokenizer dateSt = new StringTokenizer(gifticon[i], "-");

            int a = Integer.parseInt(nowSt.nextToken());
            int b = Integer.parseInt(dateSt.nextToken());
            if (a < b) {
                count++;
                continue;
            } else if (a == b) {
                a = Integer.parseInt(nowSt.nextToken());
                b = Integer.parseInt(dateSt.nextToken());
                if (a < b) {
                    count++;
                    continue;
                } else if (a == b) {
                    a = Integer.parseInt(nowSt.nextToken());
                    b = Integer.parseInt(dateSt.nextToken());
                    if (a <= b) {
                        count++;
                        continue;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
