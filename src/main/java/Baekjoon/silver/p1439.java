package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1439 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a : 0, b : 1 //
        String s = br.readLine();
        int aCount = 0;
        int bCount = 0;
        char preChar = '0';
        int length = 0;
        //0001100
        for (int i = 0; i < s.length() - 1; i++) {
            preChar = s.charAt(i);
            length++;
            if (preChar == s.charAt(i + 1)) {
                continue;
            }

            if (preChar == '0') aCount++;
            else bCount++;
        }
        if (preChar != s.charAt(length)) {
            if (preChar == '0') aCount++;
            else bCount++;
        }
        System.out.println("aCount : " + aCount + " | bCount : " + bCount);
        if(aCount != bCount && aCount == 0 || bCount == 0) System.out.println(Math.max(aCount, bCount));
        else
//        System.out.println(reverseCount(s, aCount >= bCount ? '1' : '0'));
        System.out.println(Math.min(aCount, bCount));

    }

    static int reverseCount(String s, char c) {
        int count = 0;
        int length = 0;
        int lengthCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                lengthCount++;
                continue;
            }

            if(lengthCount == 0) return count;

            count++;
        }
        deleteString(s, lengthCount, c);

        return count;
    }
    static void deleteString(String s, int lengthCount, char c){
        s = s.replace(String.valueOf(c).repeat(lengthCount), "");
    }

}
