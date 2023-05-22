package Baekjoon.silver;

import java.io.*;

public class p1475 { // 아직미완성
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] b = new boolean[10];
        int n = Integer.parseInt(br.readLine());
        int one;
        int countSet = 1;
        
        while(true){
            one = n % 10;

            if(!b[one]){
                b[one] = true;
            }else if(one == 6 && !b[9]){
                b[9] = true;
            }else if(one == 9 && !b[6]){
                b[6] = true;
            }else {
                countSet++;
                b = new boolean[10];
                b[one] = true;
            }
            if(n < 10){
                break;
            }
            n /= 10;
        }
        System.out.println(countSet);

    }

}
