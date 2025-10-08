package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12919 {

    static boolean SToTAvailable = false;
    static String a;
    static StringBuilder b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = new StringBuilder(br.readLine());

        recur(b);

        if(SToTAvailable){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void recur(StringBuilder str){
        if(str.length() == a.length()) {
            if(str.toString().equals(a)){
                SToTAvailable = true;
            }
        } else {
            if(str.charAt(0) == 'B'){
                StringBuilder sb = new StringBuilder(str).reverse();
                sb.setLength(str.length()-1);
                recur(sb);
            }
            if(str.charAt(str.length()-1) == 'A'){
                StringBuilder sb = new StringBuilder(str);
                sb.setLength(str.length()-1);
                recur(sb);
            }
        }
    }
}
