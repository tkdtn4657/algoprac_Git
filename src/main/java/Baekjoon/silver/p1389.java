package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 친구 수
        int m = Integer.parseInt(st.nextToken()); // 명령 수

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al.get(a).add(b);
            al.get(b).add(a);

        }

        //각 사람별로 for문을 돌릴거고, 그때마다 visited를 초기화
        //수를 기준으로 값을 int배열에 저장

        int[] cevinVaconSum = new int[n+1];
        for(int people = 1; people <= n; people++){
            boolean[] visited = new boolean[n+1];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{people, 0});
            visited[people] = true;
            int sum = 0;
            while(!queue.isEmpty()){
                int[] nowPeople = queue.poll();

                for(int nextPeople : al.get(nowPeople[0])){
                    if(!visited[nextPeople]){
                        visited[nextPeople] = true;
                        sum += nowPeople[1] + 1;
                        queue.add(new int[]{nextPeople, nowPeople[1] + 1});
                    }
                }

            }

            cevinVaconSum[people] = sum;

        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(min > cevinVaconSum[i]){
                min = cevinVaconSum[i];
                result = i;
            }
        }

        System.out.println(result);

    }
}
