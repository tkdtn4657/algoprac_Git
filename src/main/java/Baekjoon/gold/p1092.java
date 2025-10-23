package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1092 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cranes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] boxes = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes);
        Arrays.sort(boxes);

        if(cranes[n-1] < boxes[m-1]){
            System.out.println(-1);
            return;
        }

        int useMinute = 0;
        int j = m-1;
        while(!isEnd(boxes)){
            useMinute++;
            for(int i = n-1; i >= 0; i--){
                while(j > 0 && boxes[j] == -1){
                    j--;
                }

                if(cranes[i] >= boxes[j] && boxes[j] != -1){
                    boxes[j] = -1;
                } else {
                    for(int g = j; g >= 0; g--){
                        if(cranes[i] >= boxes[g] && boxes[g] != -1){
                            boxes[g] = -1;
                            j = g;
                            break;
                        }
                    }
                }
            }
            j = m-1;
        }

        System.out.println(useMinute);
    }

    private static boolean isEnd(int[] boxes){
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i] != -1) return false;
        }

        return true;
    }
}
