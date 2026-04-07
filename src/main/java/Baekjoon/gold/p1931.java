package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        list.sort((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int next = list.get(0)[1];
        int count = 1;
        for(int i = 1; i < n; i++){
            Integer[] now = list.get(i);

            if(next <= now[0]){
                count++;
                next = now[1];
            }

        }

        System.out.println(count);
    }
}
