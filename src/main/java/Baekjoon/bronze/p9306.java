package Baekjoon.bronze;

import java.io.*;

public class p9306 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        int count = 1;
        for(int i = 0; i < n; i++){
            String s1 = br.readLine();
            String s2 = br.readLine();
            sb.append("Case ").append(count++).append(": ").append(s2).append(", ").append(s1).append("\n");
        }
        System.out.println(sb);
    }
}
