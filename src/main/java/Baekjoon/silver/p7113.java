package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p7113 {

    static int count = 0;
    static int min, max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rectSlice(n, m);

        System.out.println(count);
    }

    static void rectSlice(int n, int m){
        if(n == m){
            count++;
            return;
        }else{
            min = Integer.min(n, m);
            max = Integer.max(n,m);
            rectSlice(min, min);
            rectSlice(min, max-min);
        }
    }
}
