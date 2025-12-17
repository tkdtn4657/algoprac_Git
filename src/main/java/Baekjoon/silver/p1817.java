package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int count = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(st.nextToken());
            if(sum + number <= m) {
                sum += number;
            } else {
                sum = number;
                count++;
            }

        }

        System.out.println(count);

    }
}
