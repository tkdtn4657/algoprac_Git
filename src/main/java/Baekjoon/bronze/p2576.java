package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p2576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int min = 101;
        int sum = 0;
        for(int i = 0; i < 7; i++){
            int num = Integer.parseInt(br.readLine());
            if(num % 2 == 1){
                min = Integer.min(num, min);
                sum += num;
            }
        }

        if(min == 101){
            System.out.println(-1);
            return;
        }else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
