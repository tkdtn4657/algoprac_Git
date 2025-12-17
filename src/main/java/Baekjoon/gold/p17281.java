package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p17281 {

    static int max = 0;
    static int n;
    static int[][] a;
    static boolean[] visited;
    static boolean[] base = new boolean[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n][9];
        visited = new boolean[9];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //4번타자 3번 인덱스가 무조건 1번타석
        //이후엔 랜덤값 골라서 백트래킹 탐색해서 최대점수를 구하면 될거같은데?
        //큐부터 생성?
        Deque<Integer> batSequence = new ArrayDeque<>();
        recur(batSequence);

        System.out.println(max);

    }

    private static void recur(Deque<Integer> batSequence){
        if(batSequence.size() == 3){
            batSequence.addLast(0);
            recur(batSequence);
            batSequence.pollLast();
            return;
        }
        if(batSequence.size() == 9){
            Deque<Integer> newDeque = new ArrayDeque<>(batSequence);
            simulation(newDeque);
            return;
        }

        for(int i = 1; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                batSequence.addLast(i);
                recur(batSequence);
                batSequence.pollLast();
                visited[i] = false;
            }
        }
    }

    private static void simulation(Deque<Integer> batSequence) {
        int count = 0;
        //점수시뮬로직
        int out = 0;
        for(int inning = 0; inning < n; inning++) {
            while (true) {
                int nowBatter = batSequence.pollFirst();
                switch (a[inning][nowBatter]) {
                    case 1 :
                        for(int i = 3; i >= 1; i--){
                            if(base[i]){
                                base[i] = false;
                                if(i == 3) {
                                    count++;
                                } else {
                                    base[i+1] = true;
                                }
                            }
                        }
                        base[1] = true;
                        break;
                    case 2 :
                        for(int i = 3; i >= 1; i--){
                            if(base[i]){
                                base[i] = false;
                                if(i == 2 || i == 3) {
                                    count++;
                                } else {
                                    base[i+2] = true;
                                }
                            }
                        }
                        base[2] = true;
                        break;
                    case 3 :
                        for(int i = 3; i >= 1; i--){
                            if(base[i]){
                                base[i] = false;
                                count++;
                            }
                        }
                        base[3] = true;
                        break;
                    case 4 :
                        for(int i = 3; i >= 1; i--){
                            if(base[i]){
                                base[i] = false;
                                count++;
                            }
                        }
                        count++;
                        break;
                    case 0 :
                        out++;
                        break;
                }
                batSequence.addLast(nowBatter);

                if(out == 3){
                    out = 0;
                    Arrays.fill(base, false);
                    break;
                }
            }
        }


        max = Integer.max(count, max);
    }

}
