package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p19532_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b, c, d, e, f;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int x = -1000; x < 1000; x++){
            for(int y = -1000; y < 1000; y++){
                if((a * x) + (b * y) == c){
                    if((d * x) + (e * y) == f){
                        sb.append(x).append(" ").append(y);
                    }
                }
            }
        }

        System.out.println(sb);


    }
}
