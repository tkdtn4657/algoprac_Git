package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p1356 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

//        long left = 0;
//        long right = 0;
        String[] lr = new String[2];

        if(s.length() == 1){
            System.out.println("NO");
            return;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            return;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for(int i = 1; i < s.length(); i++){
            left.append(s.substring(0, i));
            right.append(s.substring(i));

            if(mulChar(left) == mulChar(right)){
                System.out.println("YES");
                return;
            }

            left.setLength(0);
            right.setLength(0);
        }

        System.out.println("NO");

    }

    static long mulChar(StringBuilder sb){
        long result = 1;

        for(int i = 0; i < sb.length(); i++){
            result *= sb.charAt(i) -'0';
        }

        return result;
    }

}
