package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1717 {

    static int[] alIndex;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        alIndex = new int[n+1];
        for(int i = 0; i < n+1; i++){
            alIndex[i] = i;
        }

        StringBuilder sb =new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if(mode == 0){
                union(a, b);
            }else{
                if(checkSame(a, b)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        //b를 a에 합칠것임
        if(a != b) {
            alIndex[a] = b;
        }

    }

    static int find(int a){
        if(alIndex[a] == a){
            return a;
        }else{
            int index = find(alIndex[a]);
            alIndex[a] = index;
            return alIndex[a];
        }
    }

    static boolean checkSame(int a, int b){
        if(find(a) == find(b)){
            return true;
        }else{
            return false;
        }
    }
}
