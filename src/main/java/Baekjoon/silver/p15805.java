package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15805 {

    static int totalNode = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int firstNum = 0;
        //prev보다 값이 증가하면 자식노드 추가
        //prev보다 값이 줄어들면 자식노드로 이동
        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i <= 200_000; i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        if(n == 1){
            System.out.println(1);
            System.out.println(-1);
            return;
        }
        int prev = Integer.parseInt(st.nextToken());
        firstNum = prev;
        for(int i = 1; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(prev < num){
                totalNode++;
                tree.get(prev).add(num);
            }

            prev = num;
        }

        dfs(tree, firstNum, -1);

        sb.setLength(sb.length()-1);
        System.out.println(totalNode);
        System.out.println(sb);

    }

    private static void dfs(List<List<Integer>> tree, int cur, int parent){
        List<Integer> currentNodes = tree.get(cur);
        sb.append(parent).append(" ");
        for(int node: currentNodes){
            if(parent == node) continue;
            dfs(tree, node, cur);
        }
    }
}
