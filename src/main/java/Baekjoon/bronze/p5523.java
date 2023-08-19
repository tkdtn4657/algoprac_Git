package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p5523 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int aCount = 0;
        int bCount = 0;
        int a;
        int b;
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a > b){
                aCount++;
            }
            else if(b > a){
                bCount++;
            }
        }

        System.out.println(aCount + " " + bCount);

    }
}
