package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14889 {

    static int n;
    static int[][] a;
    static int minDiffer = Integer.MAX_VALUE;
    static boolean[] players;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        players = new boolean[n];

        for(int i = 0; i < n; i++){
            a[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        pickPlayer(0, 0);

        System.out.println(minDiffer);
    }

    //팀을 어떻게 선택?
    //1, 2, 3, 4일 때
    //1, 2를 선택하면 반대는 3, 4
    //1, 3 : 2, 4
    //1, 4 : 2, 3
    //boolean 배열 기준으로 true false 나눠서 하면 됨
    private static void pickPlayer(int depth, int count){
        if(count == n/2){
            int trueScore = 0;
            int falseScore = 0;

            for(int i = 0; i < n-1; i++){
                for(int j = i + 1; j < n; j++){
                    if(players[i] && players[j]) {
                        trueScore += a[i][j];
                        trueScore += a[j][i];
                    } else if(!players[i] && !players[j]){
                        falseScore += a[i][j];
                        falseScore += a[j][i];
                    }
                }
            }

            minDiffer = Integer.min(Math.abs(trueScore - falseScore), minDiffer);
            if(minDiffer == 0){
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for(int i = depth; i < n; i++){
            if(!players[i]){
                players[i] = true;
                pickPlayer(i + 1, count + 1);
                players[i] = false;
            }
        }
    }
}
