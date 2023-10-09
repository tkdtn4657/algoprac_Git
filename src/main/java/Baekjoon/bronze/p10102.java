package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p10102 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int countA = 0;
        int countB = 0;

        for(char c : s.toCharArray()){
            if(c == 'A'){
                countA++;
            }else{
                countB++;
            }
        }

        if(countA > countB){
            System.out.println('A');
        }else if(countA < countB){
            System.out.println('B');
        }else{
            System.out.println("Tie");
        }

    }
}
