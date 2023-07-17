package Baekjoon.silver;

import java.io.*;

public class p5525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringBuilder s = new StringBuilder(br.readLine());

        StringBuilder temp = new StringBuilder("I");
        for(int i = 0; i < n; i++) {
            temp.append("OI");
        }

        int count = 0;
        for(int start = 0, end = temp.length(); end <= m;){
            if(builderSubString(start++,end++,s, temp)){
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean builderSubString(int start, int end, StringBuilder sb1, StringBuilder sb2){
        for(int i = start; i < end; i++) {
            if(sb1.charAt(i) != sb2.charAt(i-start)){
                return false;
            }
        }
        return true;
    }
}
