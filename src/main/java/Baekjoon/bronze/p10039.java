package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p10039 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        for(int i = 0; i < 5; i++){
            int n = Integer.parseInt(br.readLine());
            if(n < 40){
                result += 40;
                continue;
            }
            result += n;
        }

        System.out.println(result/5);

    }
}
