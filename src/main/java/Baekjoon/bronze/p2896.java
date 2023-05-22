package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p2896 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st;

        double[] juice = new double[3];
        double[] ratio = new double[3];
        double[] result = new double[3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            juice[i] = Double.parseDouble(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            ratio[i] = Double.parseDouble(st.nextToken());
        }

        for(int i = 0; i < 3; i++){
            result[i] = juice[i] / ratio[i];
        }

        double min = result[0];
        for(int i = 1; i < 3; i++){
             if(min > result[i]){
                 min = result[i];
             }
        }

        for(int i = 0; i < 3; i++){
            result[i] = juice[i] - (min*ratio[i]);
        }

        for( double resultNum : result){
            System.out.print(resultNum + " ");
        }

    }
}
