package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());//초기 공격력

        int[][] dungeonFloor = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            //0 : 방모드(1:몬스터방, 2:포션방) | 1 : 수치(몬스터공격력 or 용사공격력) | 2: 체력
            dungeonFloor[i][0] = Integer.parseInt(st.nextToken());
            dungeonFloor[i][1] = Integer.parseInt(st.nextToken());
            dungeonFloor[i][2] = Integer.parseInt(st.nextToken());
        }

        long minHP = Long.MAX_VALUE;
        //lowerBound를 찾기
        long left = 1;
        long right = Long.MAX_VALUE / 100;
        long mid = left + (right - left) / 2;
        while(left <= right){
            //mid 값이 용사의 체력
            Warrior warrior = new Warrior(mid, mid, h);

            simulEnd:
            for(int i = 0; i < n; i++){
                switch (dungeonFloor[i][0]){
                    case 1:
                        long monsterATK = dungeonFloor[i][1];
                        long monsterHP = dungeonFloor[i][2];
                        //hp와 atk 값을 계산 하고 죽으면 break
                        //몬스터와 싸우는걸 식으로 최소화
                        //용사가 공격, 잡으면 넘어감
                        //용사가 공격했는데 안죽으면 내가 한대 맞음
                        //반복
                        //용사 공격
//                        2 1
//                        1 1000000 1000000
//                        1 1000000 1000000

                        long turn = (long) Math.ceil((double) monsterHP / warrior.atk);
                        //몬스터를 반드시 잡을 수 있는 턴
                        //그렇기 때문에 용사가 죽는지만 확인하면 됨
                        warrior.currentHp -= (monsterATK * (turn-1));
                        if(warrior.currentHp <= 0){
                            break simulEnd;
                        }

                        break;
                    case 2:
                        long buffATK = dungeonFloor[i][1];
                        long recoverHP = dungeonFloor[i][2];
                        warrior.atk += buffATK;
                        //피회복
                        if(warrior.currentHp + recoverHP > warrior.maxHp){
                            warrior.fullRecover();
                        } else {
                            warrior.currentHp += recoverHP;
                        }
                        break;
                }
            }

            if(warrior.isAlive()){
                right = mid - 1;
                minHP = Long.min(minHP, mid);
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;

        }

        System.out.println(left);


    }

    private static class Warrior {

        long maxHp;
        long currentHp;
        long atk;

        Warrior(long maxHp, long currentHp, long atk){
            this.maxHp = maxHp;
            this.currentHp = currentHp;
            this.atk = atk;
        }

        public void fullRecover(){
            currentHp = maxHp;
        }

        public boolean isAlive(){
            return currentHp > 0;
        }
    }
}
