package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16234 {

    static int n, l, r;
    static int[][] countries;
    static boolean[][] visited;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int totalBfsCount = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        countries = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(bfs()){
                totalBfsCount++;
            } else {
                break;
            }
        }

        System.out.println(totalBfsCount);
    }

    private static boolean bfs(){
        visited = new boolean[n][n];
        boolean isMoved = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                List<Node> unionList = new ArrayList<>();
                Node node = new Node(i, j);
                unionList.add(node);
                visited[i][j] = true;
                Queue<Node> queue = new LinkedList<>();

                queue.add(node);

                int sum = countries[i][j];

                while(!queue.isEmpty()){
                    Node currentNode = queue.poll();
                    for(int[] move : moves) {
                        int dx = currentNode.x + move[0];
                        int dy = currentNode.y + move[1];

                        if(dx < 0 || dx >= n || dy < 0 || dy >= n || visited[dx][dy]) continue;

                        int differentCitizenCount = Math.abs(countries[currentNode.x][currentNode.y] - countries[dx][dy]);
                        if(differentCitizenCount >= l && differentCitizenCount <= r){
                            visited[dx][dy] = true;
                            unionList.add(new Node(dx, dy));
                            sum += countries[dx][dy];
                            queue.add(new Node(dx, dy));
                        }
                    }
                }
                if (unionList.size() > 1) {
                    int avg = sum / unionList.size();
                    for (Node nodeData : unionList) {
                        countries[nodeData.x][nodeData.y] = avg;
                    }
                    isMoved = true;
                }
            }
        }

        return isMoved;
    }

    private static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
