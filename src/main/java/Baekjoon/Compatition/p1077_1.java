package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1077_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int nSum = 0;
        int nPow = 0;
        int nPowPow = 0;
        for(int i = 1; i <= n; i++){
            nSum+= i;
            nPowPow += Math.pow(i, 3);
        }
        nPow = (int) Math.pow(nSum, 2);

        System.out.println(nSum);
        System.out.println(nPow);
        System.out.println(nPowPow);
    }
}
