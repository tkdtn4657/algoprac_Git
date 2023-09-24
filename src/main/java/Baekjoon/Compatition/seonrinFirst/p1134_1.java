package Baekjoon.Compatition.seonrinFirst;

import java.io.*;
import java.util.*;

public class p1134_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a; // 라면 계수
        int b; // 기본물
        int x; // 끓일라면
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            sb.append((a*x - a*1) + b).append("\n");
        }

        System.out.println(sb);

    }
}
