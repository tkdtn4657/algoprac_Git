package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        HashSet<String> hs = new HashSet<>();
        int count = 0;
        String s;
        while(n-->0){
            s = br.readLine();
            if(s.equals("ENTER")){
                hs.clear();
                continue;
            }
            if(hs.contains(s)) continue;
            hs.add(s);
            count++;

        }
        System.out.println(count);
    }
}
