package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14889_2 {
    static int n;
    static int[][] map;
    static int minDiffer = Integer.MAX_VALUE;
    static boolean[] players;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        players = new boolean[n];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        pickPlayer(0, 0);

        System.out.println(minDiffer);
    }

    private static void pickPlayer(int depth, int count){
        if(count == n/2){

            int trueScore = 0;
            int falseScore = 0;

            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    if(players[i] && players[j]){
                        trueScore += map[i][j];
                        trueScore += map[j][i];
                    }

                    if(!players[i] && !players[j]){
                        falseScore += map[i][j];
                        falseScore += map[j][i];
                    }
                }
            }

            minDiffer = Integer.min(Math.abs(trueScore - falseScore), minDiffer);
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
