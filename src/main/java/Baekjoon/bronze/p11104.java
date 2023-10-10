package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p11104 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String s;

        for(int j = 0; j < n; j++) {
            s = br.readLine();
            int count = 0;
            int powNum = 0;
            int result = 0;
            for (int i = 23; i >= 0; i--) {
                powNum = (int) Math.pow(2, count++);
                if (s.charAt(i) == '1') {
                    result += powNum;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }

}
