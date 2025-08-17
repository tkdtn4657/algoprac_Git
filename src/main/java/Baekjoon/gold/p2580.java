package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2580 {
    static int n = 9;
    static int[][] sudokuMap = new int[n][n];
    static List<Node> nodes = new ArrayList<>();
    static boolean endFlag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //0이 빈칸
        //나머진 숫자로 채워져있고
        //가로 줄, 세로 줄 1부터 9까지 안겹치고 나와야하고
        //3x3 위치에서도 각 1부터 9까지 나와야함

        for(int i = 0; i < n; i++){
//            sudokuMap[i] = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int indexY = 0;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                sudokuMap[i][indexY] = num;
                if(num == 0){
                    nodes.add(new Node(i, indexY));
                }
                indexY++;
            }

        }

        backtrack(0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            Arrays.stream(sudokuMap[i]).forEach(
                    number -> sb.append(number).append(" ")
            );
            sb.setLength(sb.length()-1);
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);

    }

    private static void backtrack(int depth){
        if(depth == nodes.size()){
            endFlag = true;
            return;
        }

        for(int i = 1; i <= 9; i++){
            Node node = nodes.get(depth);
            if(availableNumber(node.x, node.y, i)){
                sudokuMap[node.x][node.y] = i;
                backtrack(depth+1);
                if(endFlag) return;
                sudokuMap[node.x][node.y] = 0;
            }
        }
    }

    private static boolean availableNumber(int row, int col, int num){
        //가로
        for(int i = 0; i < n; i++) {
            if (sudokuMap[row][i] == num && num != 0){
                return false;
            }
        }
        //세로
        for(int i = 0; i < n; i++){
            if(sudokuMap[i][col] == num && num != 0){
                return false;
            }
        }
        //3x3 위치에서 판단
        int x = row / 3;
        int y = col / 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(sudokuMap[i + (3*x)][j + (3*y)] == num && num != 0){
                    return false;
                }
            }
        }

        return true;
    }

    private static class Node{
        int x, y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
