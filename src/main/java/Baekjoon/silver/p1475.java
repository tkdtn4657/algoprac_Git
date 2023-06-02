package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1475{
    public static void main()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder n = new StringBuilder(br.readLine());

        int[] a = new int[10];

        int length = n.length();
        while (length-- > 0) {
            int getNumber = n.charAt(0) - '0';
            n.deleteCharAt(0);
            a[getNumber]++;
        }




        int k = (a[6] + a[9]);
        if (k % 2 == 0) {
            a[6] = k / 2;
            a[9] = k / 2;
        }
        else {
            a[6] = k / 2 + 1;
            a[9] = k / 2 + 1;
        }

        int max = 0;
        for (int i : a) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
//public class p1475 { // 아직미완성
//
//    static int setCount = 1;
//
//    public static void main() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder n = new StringBuilder(br.readLine());
//
//        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] numSet = a.clone();
//
//        int length = n.length();
//        int getNumber;
//        while (length-- > 0) {
//            //index가 됨
//            getNumber = n.charAt(0) - '0';
//            n.deleteCharAt(0);
//            if (a[getNumber] > 0) {
//                a[getNumber]--;
//            } else if (getNumber == 9 && a[6] > 0) {
//                a[6]--;
//            } else if (getNumber == 6 && a[9] > 0) {
//                a[9]--;
//            } else {
//                plusSet(a, numSet);
//                a[getNumber]--;
//            }
//        }
//        System.out.println(setCount);
//    }
//
//    static void plusSet(int[] a, int[] b) {
//        for (int i = 0; i < a.length; i++) {
//            a[i] += b[i];
//        }
//        setCount++;
//    }
//
//}