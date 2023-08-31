package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p13251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        double[] a = new double[m];

        double totalStone = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            a[i] = Integer.parseInt(st.nextToken());
            totalStone += a[i];
        }

        int k = Integer.parseInt(br.readLine());

        double[] percent = new double[m];
        Arrays.fill(percent, 1);
        //k번 뽑을 때 확률
        for(int i = 0; i < k; i++){
            for(int j = 0; j < a.length; j++){
                percent[j] *= a[j]--/totalStone;
            }
            totalStone--;
        }

        double percentSum = 0;
        for(double value : percent){
            percentSum += value;
        }

        System.out.println(percentSum);


    }
}
