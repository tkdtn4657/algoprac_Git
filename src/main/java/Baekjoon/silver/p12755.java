package Baekjoon.silver;

import java.io.*;
import java.util.*;
public class p12755 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int length = 0;
        int i = 1;
        for(i = 1; length < n; i++){
            //10을 하려면 어떻게 하는데?
            //10일 때 1카운트 0 카운트
            length++;

            int temp = i;
            while(temp >= 10){
                length++;
                temp /= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i-1);
        sb.reverse();
        System.out.println(sb.charAt(length-n));
    }
}
