package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11725_2 {
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static int[] parentNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parentNode = new int[n+1];

        for(int i = 0; i < n + 1; i++){
            al.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al.get(a).add(b);
            al.get(b).add(a);
        }

        parentParse(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parentNode[i]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void parentParse(int nodeNum, int prevNodeNum){
        ArrayList<Integer> nowChildNodes = al.get(nodeNum);

        for(int nextNode : nowChildNodes){
            if(nextNode == prevNodeNum){
                continue;
            }

            parentNode[nextNode] = nodeNum;
            parentParse(nextNode, nodeNum);
        }
    }
}
