package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();

        //8  2   3   4   0   3   2   9   9   2   3
        //8, 12, 13, 14, 20, 23, 24, 29, 39, 42, 43

        //8 -> 12 -> 13 -> 14
        //앞에서부터 매칭되는 수를 찾아야죠


        long n;
        int charIndex = 0;
        //n을 쭉 진행시킴
        for(n = 1;; n++){
            String s = String.valueOf(n);
            char c = inputLine.charAt(charIndex);

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == c){
                    charIndex++;
                    if(charIndex < inputLine.length()){
                        c = inputLine.charAt(charIndex);
                    }
                }
                if(charIndex >= inputLine.length()) break;
            }
            if(charIndex >= inputLine.length()) break;

        }

        System.out.println(n);

    }
}
