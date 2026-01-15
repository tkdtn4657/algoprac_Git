package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p3584 {

    static Set<Integer> aSet = new HashSet<>();
//    static List<Integer> bSet = new ArrayList<>();
    static boolean aFlag = false;
    static int firstParentNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            aSet.clear();
//            bSet.clear();
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> tree = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                tree.add(new ArrayList<>());
            }

            for(int i = 0; i < n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree.get(b).add(a);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //a와 b의 공통조상 찾기

            aFlag = true;
            aSet.add(a);
            dfs(a, -1, tree);

            aFlag = false;
            dfs(b, -1, tree);

            sb.append(firstParentNode).append(System.lineSeparator());
        }

        System.out.println(sb);

    }

    private static void dfs(int cur, int parent, List<List<Integer>> tree){

        List<Integer> nodes = tree.get(cur);
        for(int node : nodes){
            if(parent == node) continue;
            if(aFlag){
                aSet.add(node);
            } else {
                if(aSet.contains(node)){
                    firstParentNode = node;
                    return;
                }
            }

            dfs(node, cur, tree);

        }

     }
}
