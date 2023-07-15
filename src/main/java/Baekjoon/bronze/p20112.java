package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p20112 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String[] s = new String[n];

        for(int i = 0 ; i < n; i++) {
            s[i] = br.readLine();
            sb1.append(s[i]);
        }

        for(int i =0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                sb2.append(s[j].charAt(i));
            }
        }

        if(sb1.toString().equals(sb2.toString())){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
