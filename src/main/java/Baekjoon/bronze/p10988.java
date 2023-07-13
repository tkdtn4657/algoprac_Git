package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p10988 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());

        int start = 0;
        int end = sb.length()-1;
        if(sb.length() == 1){
            System.out.println(1);
            return;
        }
        while(start < end){// level
            if(sb.charAt(start++) != sb.charAt(end--)) {
                System.out.println(0);
                break;
            }
            if(start >= end) {
                System.out.println(1);
            }
        }
    }
}
