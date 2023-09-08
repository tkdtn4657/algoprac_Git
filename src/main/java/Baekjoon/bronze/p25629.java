package Baekjoon.bronze;

import java.io.*;
import java.util.*;
public class p25629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int odd = 0;
        int even = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }

        if(n/2 == even){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}
