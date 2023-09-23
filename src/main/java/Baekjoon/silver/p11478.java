package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        String s = br.readLine();

        int start = 0;
        int end = 1;
        while(start <= end){
            if(start > s.length()){
                break;
            }
            set.add(s.substring(start, end));
            end++;
            if(end > s.length()){
                start++;
                end = start;
            }
        }
        System.out.println(set.size()-1);//공백이 들어갔기때문

    }
}
