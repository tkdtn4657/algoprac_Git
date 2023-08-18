package Baekjoon.bronze;

import java.io.*;

public class p1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = 0;
        int pow = 16;
        int temp = 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            temp = (int) Math.pow(pow, count++);
            if (s.charAt(i) - '0' < 10 && s.charAt(i) - '0' >= 0) {
                result += (s.charAt(i) - '0') * temp;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {
                result += (s.charAt(i) - 'A' + 10) * temp;
            }
        }
        System.out.println(result);
    }
}
