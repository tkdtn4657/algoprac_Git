package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p24568 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int n = (a * 8 + b * 3) - 28;
        if(n <= 0){
            System.out.println(0);
        }
        else{
            System.out.println(n);
        }

    }
}
