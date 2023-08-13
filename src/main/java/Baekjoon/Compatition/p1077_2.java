package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1077_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();
        int i = 1;
        int order = 0;
        if(Character.isDigit(three.charAt(0))){
            i = Integer.parseInt(three);
            order = 1;
        } else if(Character.isDigit(two.charAt(0))){
            i = Integer.parseInt(two);
            order = 2;
        } else if(Character.isDigit(one.charAt(0))){
            i = Integer.parseInt(one);
            order = 3;
        }

        for(int j = order; j > 0; j--){
            i++;
        }

        //i의 숫자 유추됨

        if(i % 3 == 0 && i % 5 == 0){
            System.out.println("FizzBuzz");
        }else if(i % 3 == 0 && i % 5 != 0){
            System.out.println("Fizz");
        }else if(i % 3 != 0 && i % 5 == 0){
            System.out.println("Buzz");
        }else{
            System.out.println(i);
        }

    }
}
