package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();

        int max;
        int maxIndex = 0;
        int temp = 0;
        for(int i = 0; i < a.length; i++){
            max = a[i];
            maxIndex = -1;
            for(int j = i+1; j < a.length; j++){
                if(max < a[j]){
                    max = a[j];
                    maxIndex = j;
                }
            }
            if(maxIndex != -1) {
                temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = (char) temp;
            }
        }
        System.out.println(new String(a));
    }
}