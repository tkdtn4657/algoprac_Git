package Baekjoon.bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class p13277 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.multiply(b));
    }
}
