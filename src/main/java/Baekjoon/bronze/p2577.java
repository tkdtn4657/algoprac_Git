package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String s = String.valueOf(a*b*c);
        int[] numberCount = new int[10];
        for(int i = 0; i < s.length(); i++){
            numberCount[Character.getNumericValue(s.charAt(i))]++;
        }

        for(int num : numberCount){
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
