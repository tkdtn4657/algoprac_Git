package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p23825 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a /=2;
        b/=2;

        System.out.println(Integer.min(a, b));

    }
}
