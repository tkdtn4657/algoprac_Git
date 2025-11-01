package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16434_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long h = Integer.parseInt(st.nextToken());//초기 공격력

        int[][] dungeonFloor = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            //0 : 방모드(1:몬스터방, 2:포션방) | 1 : 수치(몬스터공격력 or 용사공격력) | 2: 체력
            dungeonFloor[i][0] = Integer.parseInt(st.nextToken());
            dungeonFloor[i][1] = Integer.parseInt(st.nextToken());
            dungeonFloor[i][2] = Integer.parseInt(st.nextToken());
        }

        //lowerBound를 찾기
        long hp = 0;
        long minHp = 0;

        for(int i = 0; i < n; i++){
            switch (dungeonFloor[i][0]){
                case 1:
                    long monsterATK = dungeonFloor[i][1];
                    long monsterHP = dungeonFloor[i][2];

                    hp -= monsterATK * ((monsterHP-1) / h);
                    minHp = Math.min(minHp, hp);

                    break;
                case 2:
                    long buffATK = dungeonFloor[i][1];
                    long recoverHP = dungeonFloor[i][2];
                    h += buffATK;
                    hp = Math.min(0, hp + recoverHP);
                    break;
            }
        }

        System.out.println(1 - minHp);

    }
}
