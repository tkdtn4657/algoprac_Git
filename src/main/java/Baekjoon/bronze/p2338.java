package Baekjoon.bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class p2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
        System.out.println(a.add(b.multiply(BigInteger.valueOf(-1))));
        System.out.println(a.multiply(b));



    }
}
