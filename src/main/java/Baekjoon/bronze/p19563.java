package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p19563 {
    public static void main() throws IOException {// 상하좌우

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int count = Integer.parseInt(input[2]);
        //(4, 3), 7
        //절댓값
        if((Math.abs(x) + Math.abs(y)) % 2 == count % 2 && count >= Math.abs(x) + Math.abs(y)) {
            bw.write("YES");
        }
        else{
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
