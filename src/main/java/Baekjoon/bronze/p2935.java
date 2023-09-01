package Baekjoon.bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class p2935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bigIntegerA = new BigInteger(br.readLine());
        char[] c = br.readLine().toCharArray();
        BigInteger bigIntegerB = new BigInteger(br.readLine());

        if(c[0] == '+'){
            System.out.println(bigIntegerA.add(bigIntegerB));
        }else{
            System.out.println(bigIntegerA.multiply(bigIntegerB));
        }
    }
}
