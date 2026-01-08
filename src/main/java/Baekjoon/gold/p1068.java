package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1068 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nodes.add(new ArrayList<>());
        }

        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                root = i;
                continue;
            }

            List<Integer> parentNode = nodes.get(num);
            parentNode.add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());

        // 루트를 지우면 리프 0
        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        dfsAndLeafCount(nodes, root, removeNode);

        System.out.println(count);
    }

    private static void dfsAndLeafCount(List<List<Integer>> nodes, int cur, int removeNode){
        List<Integer> curNode = nodes.get(cur);
        if(curNode.isEmpty()) count++;
        for( int nextNode : curNode){
            if(nextNode == removeNode) {
                if(curNode.size() == 1) count++;
                continue;
            }
            dfsAndLeafCount(nodes, nextNode, removeNode);
        }
    }
}
