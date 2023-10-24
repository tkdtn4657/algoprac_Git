package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p13985 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int a = Integer.parseInt(String.valueOf(s.charAt(0)));
        int b = Integer.parseInt(String.valueOf(s.charAt(4)));
        int c = Integer.parseInt(String.valueOf(s.charAt(8)));

        if(a + b == c){
            System.out.println("YES");
            return;
        }

        System.out.println("NO");

    }
}
