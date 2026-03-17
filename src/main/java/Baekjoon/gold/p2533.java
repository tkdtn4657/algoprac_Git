package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2533 {

    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).nextNodes.add(nodes.get(b));
            nodes.get(b).nextNodes.add(nodes.get(a));
        }

        dp = new int[n+1][2];
        visited = new boolean[n + 1];
        dfs(nodes.get(1));
        //dp[n][0] = 얼리어답터가 아닐 때
        //dp[n][0] = 얼리어답터일 때

        System.out.println(Integer.min(dp[1][0], dp[1][1]));

    }

    private static void dfs(Node node){
        visited[node.nodeNumber] = true;

        dp[node.nodeNumber][0] = 0;
        dp[node.nodeNumber][1] = 1;

        for(Node nextNode : node.nextNodes){
            if(visited[nextNode.nodeNumber]) continue;

            dfs(nextNode);

            dp[node.nodeNumber][0] += dp[nextNode.nodeNumber][1];
            dp[node.nodeNumber][1] += Integer.min(dp[nextNode.nodeNumber][0], dp[nextNode.nodeNumber][1]);
        }
    }

    private static class Node{
        int nodeNumber;
        List<Node> nextNodes = new ArrayList<>();

        Node(int nodeNumber){
            this.nodeNumber = nodeNumber;
        }

    }
}
