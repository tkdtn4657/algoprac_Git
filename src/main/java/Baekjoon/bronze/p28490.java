package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p28490 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            max = Integer.max(max , Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }

        System.out.println(max);
    }
}
