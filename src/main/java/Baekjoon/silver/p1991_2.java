package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1991_2 {

    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new int[n + 1][2];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = st.nextToken().charAt(0) - 'A' + 1;
            int b = st.nextToken().charAt(0) - 'A' + 1;
            int c = st.nextToken().charAt(0) - 'A' + 1;

            tree[a] = new int[]{b, c};
        }

        StringBuffer sb = new StringBuffer();
        preorderRecur(1, sb);
        System.out.println(sb);

        sb = new StringBuffer();
        inorderRecur(1, sb);
        System.out.println(sb);

        sb = new StringBuffer();
        postorderRecur(1, sb);
        System.out.println(sb);
    }

    private static void postorderRecur(int node, StringBuffer sb) {
        if(node == -18 || node == 0) return;

        int leftNode = tree[node][0];
        int rightNode = tree[node][1];

        if(leftNode != -18 && leftNode != 0){
            postorderRecur(leftNode, sb);
        }
        if(rightNode != -18 && rightNode != 0){
            postorderRecur(rightNode, sb);
        }
        sb.append((char)(node + 'A' - 1));
    }

    private static void inorderRecur(int node, StringBuffer sb) {
        if(node == -18 || node == 0) return;

        int leftNode = tree[node][0];
        int rightNode = tree[node][1];

        if(leftNode != -18 && leftNode != 0){
            inorderRecur(leftNode, sb);
        }
        sb.append((char)(node + 'A' - 1));
        if(rightNode != -18 && rightNode != 0){
            inorderRecur(rightNode, sb);
        }
    }

    private static void preorderRecur(int node, StringBuffer sb){
        if(node == -18 || node == 0) return;

        int leftNode = tree[node][0];
        int rightNode = tree[node][1];
        sb.append((char)(node + 'A' - 1));
        if(leftNode != -18 && leftNode != 0){
            preorderRecur(leftNode, sb);
        }
        if(rightNode != -18 && rightNode != 0){
            preorderRecur(rightNode, sb);
        }
    }

}
