package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p17359 {

    static boolean[] check;
    static ArrayList<String> al;
    static ArrayList<Integer> stringStatusCount = new ArrayList<>();
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        al = new ArrayList<>();
        check = new boolean[n];

        int count;
        char prevChar, nowChar;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            al.add(s);
            count = 0;
            prevChar = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                nowChar = s.charAt(j);
                if (prevChar != s.charAt(j)) {
                    count++;
                }
                prevChar = nowChar;
            }
            stringStatusCount.add(count);
        }

        recursion(al.size(), -1, 0);

        System.out.println(minCount);

    }

    static void recursion(int cnt, int stringIndex, int statusCount) {
        if (cnt == 0) {
            minCount = Integer.min(statusCount, minCount);
            return;
        }

        for (int i = 0; i < al.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                if (stringIndex == -1) {
                    recursion(cnt - 1, i, statusCount + statusCounter( "", al.get(i)) + stringStatusCount.get(i));
                } else {
                    recursion(cnt - 1, i, statusCount + statusCounter( al.get(stringIndex), al.get(i)) + stringStatusCount.get(i));
                }
                check[i] = false;
            }
        }
    }

    static int statusCounter(String s1, String s2) {
        if (s1.length() == 0) {
            return 0;
        } else {
            if (s1.charAt(s1.length() - 1) != s2.charAt(0)) {
                return 1;
            }
        }
        return 0;
    }
}