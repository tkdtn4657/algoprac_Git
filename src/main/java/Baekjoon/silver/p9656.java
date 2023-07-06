package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(Integer.valueOf(br.readLine()) % 2 == 0){
            bw.write("SK");
        }else{
            bw.write("CY");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
