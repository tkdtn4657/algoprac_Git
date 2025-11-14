package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < t; test++){
            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] home = {
                    jwapyoTransper(Integer.parseInt(st.nextToken())),
                    jwapyoTransper(Integer.parseInt(st.nextToken()))};

            List<int[]> nodes = new ArrayList<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                nodes.add(new int[]{
                        jwapyoTransper(Integer.parseInt(st.nextToken())),
                        jwapyoTransper(Integer.parseInt(st.nextToken()))});
            }

            st = new StringTokenizer(br.readLine());
            int[] festival = {
                    jwapyoTransper(Integer.parseInt(st.nextToken())),
                    jwapyoTransper(Integer.parseInt(st.nextToken()))};

            boolean flag = false;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(home);

            while(!queue.isEmpty()){
                int[] nowNode = queue.poll();

                if(Math.abs(nowNode[0] - festival[0]) + Math.abs(nowNode[1] - festival[1]) <= 1000){
                    flag = true;
                    break;
                }

                for(int i = 0; i < n; i++){
                    if(visited[i]) continue;

                    int[] nextNode = nodes.get(i);
                    if(Math.abs(nowNode[0] - nextNode[0]) + Math.abs(nowNode[1] - nextNode[1]) <= 1000){
                        visited[i] = true;
                        queue.add(nextNode);
                    }
                }
            }

            if(flag) {
                sb.append("happy").append(System.lineSeparator());
            } else {
                sb.append("sad").append(System.lineSeparator());
            }
        }

        System.out.println(sb);

    }

    //-32768 ~ 32768
    private static int jwapyoTransper(int number){
        return number + 32768;
    }
}
