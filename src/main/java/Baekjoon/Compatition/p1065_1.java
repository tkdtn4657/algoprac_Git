package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1065_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            al.add(Integer.parseInt(br.readLine()));
        }
        boolean[] a = new boolean[10];

        int num;
        for(int i= 0; i < 5; i++) {
            num = al.get(i);
            if(!a[num]){
                a[num] = true;
            }else{
                a[num] = false;
            }
        }

        for(int i = 0; i < a.length; i++){
            if(a[i]){
                System.out.println(i);
            }
        }
    }
}
