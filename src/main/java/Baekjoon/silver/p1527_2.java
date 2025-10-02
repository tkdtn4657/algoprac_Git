package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1527_2 {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = a; i <= b; i++) {
            if (recur(i)) count++;
        }

        System.out.println(count);
    }

    static boolean recur(int num){
        if(num >= 10){
            int number = num%10;
            if(number == 4 || number == 7){
                return recur(num/10);
            } else {
                return false;
            }
        } else {
            return num == 4 || num == 7;
        }
    }
}
