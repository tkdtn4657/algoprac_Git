package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p15820 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean s1Pass = true;//성공을 담아두고 하나라도 틀리면
        boolean s2Pass = true;

        int output, answer;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            output = Integer.parseInt(st.nextToken());
            answer = Integer.parseInt(st.nextToken());

            if(output != answer){
                s1Pass = false;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            output = Integer.parseInt(st.nextToken());
            answer = Integer.parseInt(st.nextToken());

            if(output != answer){
                s2Pass = false;
            }
        }

        if(!s1Pass){
            System.out.println("Wrong Answer");
        }else if(!s2Pass){
            System.out.println("Why Wrong!!!");
        }else if(s2Pass){
            System.out.println("Accepted");
        }


    }
}
