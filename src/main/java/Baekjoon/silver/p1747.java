package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 1003002;
        int n = Integer.parseInt(br.readLine());
        int[] eratos = new int[size + 1];

        eratos[0] = 0;
        eratos[1] = 1;

        for (int i = 2; i <= size; i++) {
            if (eratos[i] == 0) {
                eratos[i] = 1;
                if(n <= i && isPalindrome(i)){
                    System.out.println(i);
                    return;
                }
                for (int j = i + i; j <= size; j += i) {
                    if (eratos[j] == 0) {
                        eratos[j] = -1;
                    }
                }
            }
        }
        //체를 통해 prime을 얻음
    }

    static boolean isPalindrome(int isPalindrome) {
        String temp;
        temp = String.valueOf(isPalindrome);

        for (int i = 0; i <= temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - i-1)) {
                return false;
            }
            if (i == temp.length() / 2) {
                return true;
            }
        }
        return true;
    }
}