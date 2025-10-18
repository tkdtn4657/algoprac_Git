package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p7576 {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static int m;
    static int n;
    static int count = 0;
    static int abnormalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        List<Node> firstGrowthTomatoList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    firstGrowthTomatoList.add(new Node(i, j));
                }
                map[i][j] = num;
            }
        }

        Set<Node> growAllowedTomatoList = new HashSet<>();
        firstGrowthTomatoList.forEach( n -> growAllowedTomatoList.addAll(findGrowAllowedTomatoList(n.x, n.y)));

        //1 : 익토
        //0 : 익안토
        //-1 : 토마토x

        while(!isAllGrowthTomato()){
            Queue<Node> queue = new ArrayDeque<>(growAllowedTomatoList);
            growAllowedTomatoList.clear();
            count++;
            while(!queue.isEmpty()){
                abnormalCount = 0;
                Node node = queue.poll();
                if(map[node.x][node.y] == 0) {
                    map[node.x][node.y] = 1;
                }
                growAllowedTomatoList.addAll(findGrowAllowedTomatoList(node.x, node.y));
            }
        }
        if(abnormalCount >= 2) count = -1;
        System.out.println(count);

    }

    private static Set<Node> findGrowAllowedTomatoList(int x, int y){
        Set<Node> nodeList = new HashSet<>();
        for(int[] move : moves){
            int nowX = x + move[0];
            int nowY = y + move[1];
            if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < m && map[nowX][nowY] == 0){
                nodeList.add(new Node(nowX, nowY));
            }
        }
        return nodeList;
    }

    private static boolean isAllGrowthTomato(){
        if(abnormalCount >= 2) return true;
        abnormalCount++;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) return false;
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

        @Override
        public int hashCode() {
            return Objects.hash("" + x + y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;                 // 1) 동일 참조
            if (!(o instanceof Node)) return false;     // 2) 타입 체크
            Node other = (Node) o;
            return this.x == other.x && this.y == other.y; // 3) 필드 비교
        }
    }
}
