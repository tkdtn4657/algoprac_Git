package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p17359 {

    static boolean[] check;
    static ArrayList<String> al;
    //    static ArrayList<String> stringCase = new ArrayList<>();
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        al = new ArrayList<>();
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            al.add(br.readLine());
        }

        recursion(0, al.size(), "");


//        for (String s : stringCase) {
//            minCount = Integer.min(minCount, statusCount(s));
//        }

        System.out.println(minCount);

    }

    static void recursion(int num, int cnt, String s) {
        if (cnt == 0) {
            minCount = Integer.min(statusCount(s), minCount);
            return;
        }

        if (!check[num]) {
            for (int i = 0; i < al.size(); i++) {
                check[num] = true;
                recursion(i, cnt - 1, s + al.get(i));
                check[num] = false;
            }
        }

    }

    static int statusCount(String s) {
//        System.out.println(s);
        int count = 0;
        char prevChar = s.charAt(0);
        char nowChar;
        for (int i = 1; i < s.length(); i++) {
            nowChar = s.charAt(i);
            if (prevChar != s.charAt(i)) {
                count++;
            }
            prevChar = nowChar;
        }
//        System.out.println(count);
        return count;
    }
}
