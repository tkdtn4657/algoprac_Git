package Baekjoon.silver;

import java.io.*;
import java.util.*;

class p1931{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndNum = 0;

        for(int i = 0; i < n; i++){
            if(prevEndNum <= a[i][0]){
                count++;
                prevEndNum = a[i][1];
            }
        }
        System.out.println(count);

    }
}