package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p17863 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String n =br.readLine();
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(n.charAt(i) == '5'){
                count++;
            }
        }
        if(count == 3){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
