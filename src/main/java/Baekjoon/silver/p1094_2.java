package Baekjoon.silver;

import java.io.*;
import java.text.DecimalFormat;

public class p1094_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        String s = Integer.toBinaryString(x);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}
