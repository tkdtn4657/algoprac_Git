package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dCount = 0;
        int pCount = 0;
        for(int i = 0; i < n; i++){
            if(br.readLine().charAt(0) == 'D'){
                dCount++;
            }else{
                pCount++;
            }

            if(dCount > pCount && Math.abs(dCount - pCount) >= 2){
                System.out.printf("%d:%d", dCount, pCount);
                return;
            }else if(dCount < pCount && Math.abs(pCount - dCount) >= 2){
                System.out.printf("%d:%d", dCount, pCount);
                return;
            }
        }
        System.out.printf("%d:%d", dCount, pCount);
    }
}
