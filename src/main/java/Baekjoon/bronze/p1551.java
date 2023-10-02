package Baekjoon.bronze;

import java.io.*;
import java.util.*;

public class p1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            temp = new ArrayList<>();

            for (int j = 0; j < al.size()-1; j++) {
                temp.add(al.get(j+1) - al.get(j));
            }

            al = temp;
        }

        StringBuilder sb = new StringBuilder();

        for(int num : al) {
            sb.append(num).append(",");
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);

    }
}
