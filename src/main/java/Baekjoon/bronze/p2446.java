package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2446 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String blank = " ";
        String star = "*";
        for(int i = n-1; i >= 0; i--){
            System.out.println(blank.repeat(n-i-1) + star.repeat(i*2+1));
        }
        for(int i = 1; i < n; i++){
            System.out.println(blank.repeat(n-i-1) + star.repeat(i*2+1));
        }
    }
}
