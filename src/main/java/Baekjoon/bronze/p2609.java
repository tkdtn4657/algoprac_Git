package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        lcm(a, b, gcd(a, b));

    }

    static int gcd(int a, int b) { // 24, 18 | gcd : 6 | lcm : 62 // 6이 남아. 24, 6
        if(b == 0){
            System.out.println(a);
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    static void lcm(int a, int b, int gcd) {
        System.out.println((a * b) / gcd);
    }
}
