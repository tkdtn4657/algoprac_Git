package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p2741 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

}
