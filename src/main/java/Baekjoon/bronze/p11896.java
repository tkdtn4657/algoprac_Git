package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p11896 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long result = 0;
        if(a % 2 == 1){
            a++;
        }
        for(int i = a; i <= b; i+=2){
            if(i == 2) continue;
                result += i;
        }
        System.out.println(result);
    }
}
