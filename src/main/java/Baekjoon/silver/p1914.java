package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1914 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.println(count);
        } else {
//            hanoi(n) = 2*hanoi(n-1) + 1
//             hanoi 기둥이 두개이므로 n-1두번 +1은 마지막원판
            noPrintHanoi(n, 1, 2, 3);
            System.out.println(count);
        }


    }

    static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            System.out.println(start + " " + to);
            count++;
            return;
        }
        hanoi(n - 1, start, to, mid); // 가운데로 전부 옮기기
        count++;
        System.out.println(start + " " + to);
        hanoi(n - 1, mid, start, to);

    }
    static void noPrintHanoi(int n, int start, int mid, int to) {
        if (n == 1) {
//            System.out.println(start + " " + to);
            count++;
            return;
        }
        noPrintHanoi(n - 1, start, to, mid); // 가운데로 전부 옮기기
        count++;
//        System.out.println(start + " " + to);
        noPrintHanoi(n - 1, mid, start, to);

    }
}
