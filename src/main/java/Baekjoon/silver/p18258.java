package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            Integer secondParam = null;

            if(st.hasMoreTokens()) {
                secondParam = Integer.parseInt(st.nextToken());
            }

            String lineSeparator = System.lineSeparator();
            switch (command) {
                case "push":
                    if (secondParam == null) {
                        break;
                    }
                    dq.add(secondParam);
                    break;
                case "pop":
                    if (isQueueEmpty(dq, sb)) break;
                    sb.append(dq.pop()).append(lineSeparator);
                    break;
                case "size":
                    sb.append(dq.size()).append(lineSeparator);
                    break;
                case "empty":
                    if(dq.isEmpty()) {
                        sb.append("1").append(lineSeparator);
                        break;
                    }
                    sb.append("0").append(lineSeparator);
                    break;
                case "front":
                    if (isQueueEmpty(dq, sb)) break;
                    sb.append(dq.peekFirst()).append(lineSeparator);
                    break;
                case "back":
                    if (isQueueEmpty(dq, sb)) break;
                    sb.append(dq.peekLast()).append(lineSeparator);
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }

    private static boolean isQueueEmpty(Deque<Integer> dq, StringBuilder sb){
        if(dq.isEmpty()){
            sb.append("-1").append(System.lineSeparator());
            return true;
        }
        return false;
    }
}
