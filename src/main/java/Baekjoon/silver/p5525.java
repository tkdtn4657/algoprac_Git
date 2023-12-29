package Baekjoon.silver;

import java.io.*;

public class p5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int count = 0;
        int answer = 0;
        int oPoint = 1;

        while (oPoint < s.length()-1) {
            if (s.charAt(oPoint - 1) == 'I' && s.charAt(oPoint) == 'O' && s.charAt(oPoint + 1) == 'I') {
                count++;
                if (count == n) {
                    count--;
                    answer++;
                }
                oPoint++;
            } else {
                count = 0;
            }
            oPoint++;
        }

        System.out.println(answer);
    }
}