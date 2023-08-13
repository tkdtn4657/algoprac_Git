package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1093_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int i= Integer.parseInt(st.nextToken());
        int a= Integer.parseInt(st.nextToken());
        int r= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());

        int result = (h*i) - (a * r * c);
        System.out.println(result);
    }
}
