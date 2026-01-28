package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p19236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[][] map = new Fish[4][4];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[i][j] = new Fish(a, b);
            }
        }

        //상어 세팅
        Shark shark = new Shark(-1, map[0][0].direction.direction);
        map[0][0] = shark;

        //물고기 이동(물고기 위치에 따라서 이동 및 교환!)
        fishContinue:
        for(int fish = 1; fish < 16; fish++){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    //물고기가 이동할 차례인지 확인
                    if(map[i][j].number == fish){
                        Fish nowFish = map[i][j];
                        if(nowFish.direction.moveAvailable(map, i, j)){
                            fishMove(map, i, j);
                            continue fishContinue;
                        }
                    }
                }
            }
        }

        System.out.println();

        //상어 식사
        //DFS를 통해서 모든 경우의 수를 탐색해야 함 메모리 기준으로 512기에 부족하진 않음
        //따라서 배열을 복사할 예정





    }

    private static void fishMove(Fish[][] map, int x, int y){
        Fish nowFish = map[x][y];

        //여기 버그다 ㅋㅋ
        for(int i = 1; i <= 8; i++){
            int[] dxDy = nowFish.direction.getDxDy(i);
            int dx = dxDy[0];
            int dy = dxDy[1];

            //범위를 벗어나거나 상어라면 스킵
            if(dx < 0 || dy < 0 || dx >= 4 || dy >= 4 || map[dx][dy].isShark()) continue;

            Fish tempfish = map[dx][dy];
            map[dx][dy] = nowFish;
            map[x][y] = tempfish;

        }
    }

    private static class Direction {

        //1, 2, 3, 4, 5, 6, 7, 8
        //↑, ↖, ←, ↙, ↓, ↘, →, ↗
        int direction;

        public Direction(int direction) {
            this.direction = direction;
        }

        //물고기가 이동할 수 있는지 확인(모든 경우의 수)
        public boolean moveAvailable(Fish[][] map, int x, int y){

            for(int i = 1; i <= 8; i++){
                int[] dxDy = getDxDy(i);
                int dx = dxDy[0];
                int dy = dxDy[1];

                //범위를 벗어나거나 상어라면 스킵
                if(dx < 0 || dy < 0 || dx >= 4 || dy >= 4 || map[dx][dy].isShark()) continue;

                return true;
            }
            //모든 상황에서 이동할 수 없다면 false
            return false;
        }

        public int[] getDxDy(int direction){
            switch(direction){
                case 1:
                    return new int[]{1, 0};
                case 2:
                    return new int[]{1, -1};
                case 3:
                    return new int[]{0, -1};
                case 4:
                    return new int[]{-1, -1};
                case 5:
                    return new int[]{-1, 0};
                case 6:
                    return new int[]{1, 1};
                case 7:
                    return new int[]{0, 1};
                case 8:
                    return new int[]{-1, 1};
            }

            throw new IllegalArgumentException("잘못 된 direction");
        }

    }

    private static class Shark extends Fish{
        public Shark(int a, int b) {
            super(a, b);
        }

        public boolean isShark(){
            return true;
        }
    }

    private static class Fish{

        int number;
        Direction direction;

        public Fish(int a, int b) {
            this.number = a;
            this.direction = new Direction(b);
        }

        public boolean moveAvailable(Fish[][] map, int x, int y){
            return this.direction.moveAvailable(map, x, y);
        }

        public boolean isShark(){
            return false;
        }
    }
}
