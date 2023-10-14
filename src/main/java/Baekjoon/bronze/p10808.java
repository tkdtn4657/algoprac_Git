package Baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] a = new int[26];

        for(int i = 0; i < s.length(); i++){
            a[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : a){
            sb.append(n).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);


    }
}
