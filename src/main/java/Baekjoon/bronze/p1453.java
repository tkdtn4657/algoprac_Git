package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p1453 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] a = new boolean[101];
        int count = 0;
        for(int i = 1; i <= n; i++){
            int chk = Integer.parseInt(st.nextToken());
            if(!a[chk]) {
                a[chk] = true;
            }else{
                count++;
            }
        }

        System.out.println(count);
    }
}
