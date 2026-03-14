package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p35067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Field> list = new ArrayList<>();


        list.add(new Field(0, 0));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            list.add(new Field(i, Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).nextFields.add(list.get(b));
            list.get(b).nextFields.add(list.get(a));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            boolean[] visited = new boolean[n+1];
            PriorityQueue<Field> pq = new PriorityQueue<>( ((o1, o2) -> o2.power - o1.power));
            pq.add(list.get(i));
            visited[i] = true;

            int lastNode = 0;
            while(!pq.isEmpty()){
                Field nowField = pq.poll();
                pq.clear();
                lastNode = nowField.nowNumber;

                Queue<Field> queue = new ArrayDeque<>();
                while(!nowField.nextFields.isEmpty()){
                    Field field = nowField.nextFields.pollFirst();
                    queue.add(field);

                    if(!visited[field.nowNumber]){
                        visited[field.nowNumber] = true;
                        pq.add(list.get(field.nowNumber));
                        break;
                    }
                }
                queue.forEach(usedField -> nowField.nextFields.add(usedField));

            }

            sb.append(lastNode).append(System.lineSeparator());

        }

        System.out.println(sb);

    }

    private static class Field{
        int nowNumber;
        TreeSet<Field> nextFields = new TreeSet<>((o1, o2) -> o2.power - o1.power);
        int power;

        public Field(int nowNumber, int power) {
            this.nowNumber = nowNumber;
            this.power = power;
        }
    }
}
