package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p25183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char prevChar = s.charAt(0);
        boolean flag = false;
        int count = 1;
        for(int i = 1; i < n; i++){
            char nowChar = s.charAt(i);
            if(Math.abs(prevChar - nowChar) == 1 || Math.abs(nowChar - prevChar) == 1){
                count++;
                if(count == 4) {
                    flag = true;
                    break;
                }
            } else {
                count = 0;
            }

            prevChar = nowChar;

        }

        if(flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
