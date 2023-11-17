package Baekjoon.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class p30455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Gamer[] map = new Gamer[n];
        Gamer duck = new Gamer(0, "Duck");
        Gamer goose = new Gamer(n - 1, "Goose");
        Gamer nothing = new Gamer(0,"No");

        Arrays.fill(map,nothing);

        map[0] = duck;
        map[n-1] = goose;

        /**
         * 첫 턴은 건덕시작
         * 좌우로 이동하거나 좌우에 상대가 있다면 공격
         */

        while (true) {

            if(map[duck.getNow()+1].equals(goose)){
                //건구스발견 -> 공격
                System.out.println("Duck");
                return;
            }
            map[duck.move(1)+1] = duck;

            if(map[goose.getNow()-1].equals(duck)){
                //건덕발견 -> 공격
                System.out.println("Goose");
                return;
            }
            map[goose.move(-1)-1] = goose;

        }

    }

    static class Gamer {
        int now;
        String name;
        Gamer(int n, String name){
            this.now = n;
            this.name = name;
        }

        public int getNow() {
            return now;
        }

        public int move(int i) {
            int returnNow = now;
            now+=i;
            return returnNow;
        }

    }

}
