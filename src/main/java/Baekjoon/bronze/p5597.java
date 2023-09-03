package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p5597 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[30];

        for(int i = 0; i < 28; i++){
            a[Integer.parseInt(br.readLine())-1]++;
        }

        for(int i = 0; i< 30; i++){
            if(a[i] == 0){
                System.out.println(i+1);
            }
        }

    }
}
