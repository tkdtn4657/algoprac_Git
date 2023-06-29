package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] sl;
        int length = 0;
        int count=1;
        for (int i = 0; i < n; i++) {
            sl = br.readLine().split(" ");

            for (int j = 0; j < sl.length; j++) {
                stack.push(sl[j]);
            }

            sb.append("Case #").append(count++).append(":");
            for (int j = 0; j < sl.length; j++) {
                sb.append(" ").append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
