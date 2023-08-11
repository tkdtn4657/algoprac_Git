package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p18352 {

    static int n, m, k, x;
    static ArrayList<Integer>[] al;
    static boolean[] check;
    static ArrayList<Integer> countArray = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//도시
        m = Integer.parseInt(st.nextToken());//도로
        k = Integer.parseInt(st.nextToken());//원하는최단거리
        x = Integer.parseInt(st.nextToken());//시작위치

        al = new ArrayList[n+1];
        check = new boolean[n+1];

        for(int i = 0; i < n+1; i++){
            al[i] = new ArrayList<Integer>();
        }

        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            //단방향초기화
            al[a].add(b);

        }

        bfs(k, x);

        StringBuilder sb= new StringBuilder();
        if(countArray.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(countArray);
            for(int num : countArray){
                sb.append(num).append("\n");
            }
            System.out.println(sb);
        }

    }

    static void bfs(int k, int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(null);
        check[x] = true;
        int count = 0;

        while(!q.isEmpty()){
            Integer now = q.poll();
            if(now == null){
                if(!q.isEmpty()) {
                    q.add(null);
                    count++;
                }
            }else {
                for (int num : al[now]) {
                    if (!check[num]) {
                        check[num] = true;
                        q.add(num);
                        if (count == k-1) {
                            countArray.add(num);
                        }
                    }
                }
            }
        }
    }
}
