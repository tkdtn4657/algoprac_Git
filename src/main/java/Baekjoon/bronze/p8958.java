package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String s= br.readLine();
            boolean flag = false;
            int result = 0;
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    if(flag){
                        count = count + 1;
                    }else{
                        flag = true;
                        count=1;
                    }
                    result += count;
                }else{
                    if(flag){
                        count = 0;
                    }
                    flag = false;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
