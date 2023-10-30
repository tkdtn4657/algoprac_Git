package Baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p12034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int p = Integer.parseInt(br.readLine());
            ArrayList<Long> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p*2; j++) {
                list.add(Long.parseLong(st.nextToken()));
            }



//            List<Integer> filterdList = list.stream()
//                    .filter(num -> list.contains((int)(num - (num * 0.25))))
//                            .toList();
//스트림은 중복값때문에 포기


            sb.append("Case #").append(i+1).append(": ");

            for(int j = 0; j < list.size(); j++) {
                if (list.get(j) != 0 && list.contains(list.get(j) * 4 / 3)) {
                    list.set(list.indexOf(list.get(j) * 4 / 3), 0L);
                }
            }

            list.stream()
                    .filter(num -> num != 0)
                            .forEach(num -> sb.append(num).append(" "));

            sb.append("\n");

        }

        System.out.println(sb);
    }
}
