package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1259 {

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> isPalindrome = new ArrayList<String>();

        int center = 0;
        String left = "";
        String right = "";


        while (true) {
            String n = br.readLine();
            if (n.equals("0")) {
                break;
            }
            //중간값을 찾은 후에 기준으로 좌우를 살피기
            center = n.length() / 2;
            if (n.length() % 2 == 0) {//길이가 짝수
                left = n.substring(0, center);
                right = n.substring(center, n.length());
            }
            if (n.length() % 2 != 0) {//길이가 홀수
                left = n.substring(0, center);
                right = n.substring(center + 1, n.length());
            }

            char[] cArray = new char[right.length()];

            int cArrayIndex = 0;
            for (int i = right.length() - 1; i >= 0; i--) { // 문자열뒤집어서 저장
                cArray[cArrayIndex++] = right.charAt(i);
            }

            right = new String(cArray);

            if (left.equals(right)) {
                isPalindrome.add("yes");
            } else {
                isPalindrome.add("no");
            }
        }

        for (String yesOrNo : isPalindrome) {
            System.out.println(yesOrNo);
        }
    }
}