package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p20499 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine(), "/");

        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        if(k+a < d || d == 0){
            System.out.println("hasu");
        }else{
            System.out.println("gosu");
        }
    }
}
