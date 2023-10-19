package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p24510 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = "";
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            s = br.readLine();
            count = 0;
            s = s.replace("for", ",");
            s = s.replace("while", ",");

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == ','){
                    count++;
                }
            }

            max = Integer.max(max, count);
        }

        System.out.println(max);

    }
}
