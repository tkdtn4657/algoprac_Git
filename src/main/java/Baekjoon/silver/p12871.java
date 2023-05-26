package Baekjoon.silver;

import java.util.*;
import java.io.*;
public class p12871 {
    public static void main()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        if(a.length() == b.length()){
            System.out.println(a.equals(b)? 1 : 0);
            return;
        }

        //최소공배수
        int lcmCount = a.length() * b.length() / gcd(a.length(), b.length());

        while(lcmCount != sbOne.length()){
            sbOne.append(a);
        }
        while(lcmCount != sbTwo.length()){
            sbTwo.append(b);
        }
        System.out.println(sbOne.toString().equals(sbTwo.toString())? 1 : 0);
    }
    static int gcd(int n1, int n2){
        if(n1 % n2 == 0){
            return n2;
        }
        return gcd(n2, n1%n2);
    }
}
