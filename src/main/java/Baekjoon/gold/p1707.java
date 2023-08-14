package Baekjoon.gold;

import java.io.*;
import java.util.*;
class p1707{
    static boolean[] visited;
    static ArrayList<Integer>[] al;
    static int[] check;
    static boolean isCheck = false;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int k = 0; k < t; k++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            isCheck = false;
            al = new ArrayList[n+1];
            check = new int[n+1];
            visited = new boolean[n+1];

            for(int i = 1; i < n+1; i++){
                al[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                al[a].add(b);
                al[b].add(a);
            }

            for(int i = 1; i < n+1; i++){
                if(!isCheck){
                    dfs(i);
                }else{
                    break;
                }
            }

            if(!isCheck){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int num){
        visited[num] = true;

        for(int number : al[num]){
            if(!visited[number]){

                check[number] = (check[num]+1) % 2;
                dfs(number);
            }else{
                if(check[num] == check[number]){
                    isCheck = true;
                }
            }
        }
    }
}