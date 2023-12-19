package Baekjoon.bronze;

import java.io.*;

public class p19602 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if(a*1 + b*2 + c*3 >= 10){
            System.out.println("happy");
        }else{
            System.out.println("sad");
        }
    }
}
