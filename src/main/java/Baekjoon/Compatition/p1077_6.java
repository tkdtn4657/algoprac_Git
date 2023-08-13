package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1077_6 {
    static boolean isLucky = false;
    static ArrayList<String[]> sl = new ArrayList<>();
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
//        int n; n은 재귀를 위해 스태틱으로 옮겼음
        int k;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            isLucky = false;
            k = 1;
            n = Integer.parseInt(br.readLine());
            sl = new ArrayList<>();

            for(int j = 0; j < n; j++){
                sl.add(br.readLine().split(" "));
            }

            back_Track(0, k);

            if (isLucky) {
                sb.append("LUCKY").append("\n");
            } else {
                sb.append("UNLUCKY").append("\n");
            }
        }

        System.out.println(sb);

    }

    static void back_Track(int count, int k) throws IOException {
        if (count == n) {//종료
            if (k % 7 == 0) {
                isLucky = true;
            }
            return;
        }

//        String s[] = br.readLine().split(" ");
        String[] s = sl.get(count);

        for (int i = 0; i < s.length; i += 2) {
            if (s[i].equals("+")) {
                back_Track(count + 1, k + Integer.valueOf(s[i + 1]));
            } else if (s[i].equals("*")) {
                back_Track(count + 1, k * Integer.valueOf(s[i + 1]));
            }
        }
    }
}
