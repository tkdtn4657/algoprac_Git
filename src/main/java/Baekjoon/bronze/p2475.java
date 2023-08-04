package Baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class p2475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        while(st.hasMoreTokens()){
            result += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println(result % 10);
    }
}
