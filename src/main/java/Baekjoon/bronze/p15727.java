package Baekjoon.bronze;
import java.io.*;
import java.util.*;
public class p15727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i+=5){
            count++;
        }
        System.out.println(count);
    }
}
