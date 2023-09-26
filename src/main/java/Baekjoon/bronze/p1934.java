package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb=  new StringBuilder();
        StringTokenizer st;
        int a;
        int b;


        //lcm gcd 최소공배수는 최대공약수가 먼저 필요함
        //gcd가 최대공약수
        //gcd = 두 수를 가장 작게나눌 수 있는 수
        //lcm = 기존 값에 최대공약수를 나눈 수(두 수의 최소약수로 구할 수 있는 수)
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int lcm = (a * b) / gcd(a, b);
            sb.append(lcm).append("\n");
        }

        System.out.println(sb);
    }
    static int gcd(int a, int b){
        if(b == 0){ // 1로 나누어떨어질 때
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
}
