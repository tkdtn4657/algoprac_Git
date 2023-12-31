package Baekjoon.bronze;

import java.io.*;
import java.util.stream.IntStream;

public class p14038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winCount = (int) IntStream.range(0, 6).filter(i -> {
            try {
                return br.readLine().trim().equals("W");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }).count();

        if(winCount > 4) System.out.println(1);
        else if(winCount > 2) System.out.println(2);
        else if(winCount > 0) System.out.println(3);
        else System.out.println(-1);
    }
}