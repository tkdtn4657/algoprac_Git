package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p25511 {

    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(p).add(c);
        }

        st = new StringTokenizer(br.readLine());
        int[] value = new int[n];
        for(int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, tree, value, k);

        System.out.println(result);
    }

    private static void dfs(int cur, int depth, List<List<Integer>> tree, int[] value, int k){
        List<Integer> nextNodes = tree.get(cur);

        if(value[cur] == k) {
            result = depth;
            return;
        }

        for(Integer nextNode : nextNodes){
            dfs(nextNode, depth+1, tree, value, k);
        }

    }
}
