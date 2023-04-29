package Baekjoon.silver;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class p24444 {

    static boolean[] isVisit;
    static ArrayList<Integer>[] a;

    public static void main() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int u, v;


        isVisit = new boolean[m+1];
        a = new ArrayList[m+1];

        for(int i = 1; i < m + 1; i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < n; i++){
            u = sc.nextInt();
            v = sc.nextInt();

            a[u].add(v);
            a[v].add(u);

        }

        BFS(r);
    }

    static void BFS(int r){


    }


}
