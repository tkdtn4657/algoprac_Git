package Baekjoon.bronze;

import java.io.*;

public class p13752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println("=".repeat(Integer.parseInt(br.readLine())));
        }
    }
}
