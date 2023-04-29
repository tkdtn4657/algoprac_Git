package Baekjoon.silver;

import java.util.*;

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

        for(int i = 1; i < m + 1; i++){
            if(!a[i].isEmpty()) {
                Collections.sort(a[i]);
            }
        }
        BFS(r, m);
    }

    static void BFS(int r, int m){ // r이 1이라고 가정했을 때
        Queue<Integer> queue = new LinkedList<>();

        int temp;
        int[] count = new int[m+1];
        int countNum = 1;

        isVisit[r] = true;
        count[r] = countNum++;
        queue.offer(r);

        while(!queue.isEmpty()){
            temp = queue.poll();
            for(int i = 0; i < a[temp].size(); i++) {
                if (!isVisit[a[temp].get(i)]) {//방문하지 않았을 때 실행
                    isVisit[a[temp].get(i)] = true;
                    count[a[temp].get(i)] = countNum++;
                    queue.offer(a[temp].get(i));
                }
            }
        }

        for(int i = 1; i < m+1; i++){
            System.out.println(count[i]);
        }
    }
}
