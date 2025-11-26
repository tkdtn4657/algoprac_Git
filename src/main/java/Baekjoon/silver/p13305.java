package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] distance = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] gasStation = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < gasStation.length; i++){
            gasStation[i] = Integer.parseInt(st.nextToken());
        }

        long currentFee = Integer.MAX_VALUE;
        long sumFee = 0;
        for(int i = 0; i < distance.length; i++){
            if(currentFee > gasStation[i]){
                currentFee = gasStation[i];
            }

            sumFee += distance[i] * currentFee;
        }

        System.out.println(sumFee);

    }
}
