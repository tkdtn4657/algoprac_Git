package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p14405 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] a = {"pi", "ka", "chu"};

        for(int i = 0; i < 3; i++){
            s = s.replaceAll(a[i], "x".repeat(a[i].length()));
        }

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'x'){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }
}
