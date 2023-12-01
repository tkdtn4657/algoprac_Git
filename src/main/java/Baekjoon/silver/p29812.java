package Baekjoon.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class p29812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int energy = 0;
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine()).append("HYU");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> noHYUList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!isHYU(sb.charAt(i))) {
                noHYUList.add(i);
            }
        }

        boolean flag;

        while (!noHYUList.isEmpty()) {
            flag = false;
            final int firstIndex = noHYUList.poll();
            int prevIndex = firstIndex;
            int count = 1;

            while (!noHYUList.isEmpty()) {
                int isContinuousIndex = noHYUList.peek();
                if (isContinuousIndex - prevIndex == 1) {
                    prevIndex = noHYUList.poll();
                    flag = true;
                    count++;
                } else {
                    break;
                }
            }
            if (!flag || count * d < m + d) {
                energy += d * count;
            } else {
                energy += d + m;
            }
        }

        Map<HYU, Long> result = sb.toString().chars()
                .filter(c -> isHYU(c))
                .boxed()
                .collect(Collectors.groupingBy((Integer c) -> HYU.valueOf(changeHYU(c)), Collectors.counting()));

        int min = Integer.MAX_VALUE;
        for (Object num : result.keySet()) {
            min = Integer.min(Math.toIntExact(result.get(num)), min);
        }

        sb = new StringBuilder();
        if (energy == 0) {
            sb.append("Nalmeok");
        } else {
            sb.append(energy);
        }
        sb.append(System.lineSeparator());
        if (min == 1 || Integer.MAX_VALUE == min) {
            sb.append("I love HanYang University");
        } else {
            sb.append(min - 1);
        }
        System.out.println(sb);

    }

    static boolean isHYU(int a) {
        switch (a) {
            case 'H', 'Y', 'U':
                return true;
            default:
                return false;
        }
    }

    static String changeHYU(int c) {
        return String.valueOf((char) c);
    }

    private enum HYU {
        H,
        Y,
        U
    }
}
