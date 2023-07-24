package Baekjoon.silver;

import java.io.*;
import java.util.*;

class p1439_2{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s, "1");
        StringTokenizer st2 = new StringTokenizer(s, "0");
        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
    }
}