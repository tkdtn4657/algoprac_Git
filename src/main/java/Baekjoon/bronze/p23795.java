package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p23795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n;
        int result = 0;
        while((n = Integer.parseInt(br.readLine())) != -1){
            result += n;
        }

        System.out.println(result);
    }
}
