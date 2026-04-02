package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16113 {

    static char[][] map;

    static int[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String inputString = br.readLine();

        int length = n/5;

        map = new char[5][length];
        for(int i = 0; i < 5; i++){
            String eachLine = inputString.substring(i*length, (i*length)+length);
            for(int j = 0; j < eachLine.length(); j++){
                map[i][j] = eachLine.charAt(j);
            }
        }

        boolean[][] visited = new boolean[5][length];

        //'#' 발견 시 bfs로 visited 채우고 이후 더 안돌림
        //visited 채우고 해당 위치 로직 돌림

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(!visited[0][i] && map[0][i] == '#'){

                sb.append(Number.getNumber(0, i));

                visited[0][i] = true;
                Queue<Integer[]> queue = new ArrayDeque<>();

                queue.add(new Integer[]{0, i});
                while(!queue.isEmpty()){
                    Integer[] now = queue.poll();

                    for(int[] move : moves){
                        int dx = move[0] + now[0];
                        int dy = move[1] + now[1];

                        if(dx < 0 || dy < 0 || dx >= 5 || dy >= length || visited[dx][dy] || map[dx][dy] == '.') continue;

                        visited[dx][dy] = true;

                        queue.add(new Integer[]{dx, dy});

                    }


                }
            }
        }

        System.out.println(sb);

    }

    private static class Number{

        public static int getNumber(int x, int y){

            if(y >= map[0].length-1){
                if(isOne(x, y, map)) return 1;
            }
            if(isZero(x, y, map)) return 0;
            if(isOne(x, y, map)) return 1;
            if(isTwo(x, y, map)) return 2;
            if(isThree(x, y, map)) return 3;
            if(isFour(x, y, map)) return 4;
            if(isFive(x, y, map)) return 5;
            if(isSix(x, y, map)) return 6;
            if(isSeven(x, y, map)) return 7;
            if(isEight(x, y, map)) return 8;
            if(isNine(x, y, map)) return 9;
            return -1;
        }

        private static boolean isZero(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isOne(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '.'},
                    {'#', '.'},
                    {'#', '.'},
                    {'#', '.'},
                    {'#', '.'}
            };

            char[][] numberTwo ={
                    {'#'},
                    {'#'},
                    {'#'},
                    {'#'},
                    {'#'}
            };

            if(y >= map[0].length-2){
                //numberTwo 써야함
                return matchNumber(x, y, map, numberTwo);
            } else {
                return matchNumber(x, y, map, number);
            }
        }

        private static boolean isTwo(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isThree(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isFour(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '.', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isFive(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isSix(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'#', '.', '.'},
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isSeven(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'},
                    {'.', '.', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isEight(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean isNine(int x, int y, char[][] map){
            char[][] number ={
                    {'#', '#', '#'},
                    {'#', '.', '#'},
                    {'#', '#', '#'},
                    {'.', '.', '#'},
                    {'#', '#', '#'}
            };

            return matchNumber(x, y, map, number);
        }

        private static boolean matchNumber(int x, int y, char[][] map, char[][] toNumber){
            for(int i = 0; i < toNumber.length; i++){
                for(int j = 0; j < toNumber[0].length; j++){
                    if(map[i+x][j+y] != toNumber[i][j]){
                        return false;
                    }
                }
            }

            return true;
        }

    }
}
