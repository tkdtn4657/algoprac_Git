package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2606_2 {

    static boolean[] visited;
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> node;
    static int infectedComputerCount = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n : 컴퓨터 수
        // m : 경로
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        if(n == 0){
            System.out.println(0);
            return;
        }
        visited = new boolean[n+1];
        //노드 초기화
        node = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            node.add(i, new ArrayList<>());
        }

        //노드 입력
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            int nodeValue = Integer.parseInt(st.nextToken());
            node.get(nodeNumber).add(nodeValue);
            node.get(nodeValue).add(nodeNumber);
        }

        //1번 컴퓨터가 바이러스에 걸렸을 때 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력(본인 제외)
//        dfs(1);
        bfs(1);

        System.out.println(infectedComputerCount);

    }

    private static void bfs(int nodeNumber){

        visited[nodeNumber] = true;
        Queue<Integer> qList = new LinkedList<>(node.get(nodeNumber));
        ArrayList<Integer> nextNodeList = new ArrayList<>();

        while(!qList.isEmpty()) {
            for (int nodeNum : qList) {
                if (visited[nodeNum]) continue;

                visited[nodeNum] = true;
                infectedComputerCount++;
                nextNodeList.add(nodeNum);
            }

            qList.clear();
            if(!nextNodeList.isEmpty()){
                for(int nextNodeNum : nextNodeList){
                    qList.addAll(node.get(nextNodeNum));
                }
                nextNodeList.clear();
            }
        }
    }

    private static void dfs(int nodeNumber){
        visited[nodeNumber] = true;
        ArrayList<Integer> list = node.get(nodeNumber);

        for(int nodeNum : list){
            if(visited[nodeNum]) continue;

            visited[nodeNum] = true;
            infectedComputerCount++;
            dfs(nodeNum);
        }
    }
}
