package Baekjoon.bronze;

import java.io.*;

public class p6887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println("The largest square has side length " + (int) Math.floor(Math.sqrt(n)) + ".");

    }
}
