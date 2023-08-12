package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p985_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int power = 0;
        int level = 0;
        Integer[] a = new Integer[n];

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        if(a.length > 42){
            Arrays.sort(a, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return o2 - o1;
                }
            });
            for(int i = 0; i < 42; i++){
                power += levelPower(a[i]);
                level += a[i];
            }
        }else {
            for (int i = 0; i < n; i++) {
                power += levelPower(a[i]);
                level += a[i];
            }
        }

        System.out.println(level + " " + power);
    }
    private static int levelPower(int level){
        if(level >= 250){
            return 5;
        }else if(level >= 200){
            return 4;
        }else if(level >= 140){
            return 3;
        }else if(level >= 100){
            return 2;
        }else if(level >= 60){
            return 1;
        }else{
            return 0;
        }
    }
}
