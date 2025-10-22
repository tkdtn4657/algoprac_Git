package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p4796 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(true){

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l == 0 && p == 0 && v == 0) break;

            int result = 0;

            int allBlock = v / p;
            int remainBlock = v % p;

            result = l * allBlock + Integer.min(remainBlock, l);
            sb.append("Case ").append(++count).append(": ").append(result).append(System.lineSeparator());
            st = new StringTokenizer(br.readLine());

        }

        System.out.println(sb);

    }
}
