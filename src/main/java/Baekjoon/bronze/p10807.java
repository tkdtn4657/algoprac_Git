package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++){
             if(v == Integer.parseInt(st.nextToken())){
                 count++;
             }
        }

        System.out.println(count);

    }
}
