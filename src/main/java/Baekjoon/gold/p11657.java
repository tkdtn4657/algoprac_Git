package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p11657 {
    static long[] distance;
    static p11657Edge[] edges;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean isMinus = false;

        edges = new p11657Edge[m+1];
        distance = new long[n+1];



        for(int i = 1; i < n+1; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new p11657Edge(start, end, weight);
        }

        for(int i = 1; i < n; i++){//distance 노드갯수만큼
            for(int j = 0; j < m; j++){//간선갯수만큼
                p11657Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE &&  distance[edge.end] > distance[edge.start] + edge.weight){
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }


        //한번을 더 돌려서 마이너스사이클 즉 값의 변경이 있는지 확인
        for(int i = 0; i < m; i++){
            p11657Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight){
                isMinus = true;
            }
        }

        if(!isMinus){
            for(int i = 2; i <= n; i++){
                if(distance[i] == Integer.MAX_VALUE){
                    System.out.println("-1");
                }else{
                    System.out.println(distance[i]);
                }
            }
        }else{
            System.out.println("-1");
        }
    }
}

class p11657Edge{
    int start, end, weight;
    public p11657Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
