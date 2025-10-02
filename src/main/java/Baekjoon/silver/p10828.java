package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            Integer param = null;
            if(st.hasMoreTokens()){
                param = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "push" :
                    stack.push(param);
                    break;
                case "pop" :
                    if(stack.isEmpty()) {
                        sb.append(-1).append(System.lineSeparator());
                        break;
                    }
                    sb.append(stack.pop()).append(System.lineSeparator());
                    break;
                case "size" :
                    sb.append(stack.size()).append(System.lineSeparator());
                    break;
                case "empty" :
                    if(stack.isEmpty()){
                        sb.append(1).append(System.lineSeparator());
                        break;
                    }
                    sb.append(0).append(System.lineSeparator());
                    break;
                case "top" :
                    if(stack.isEmpty()) {
                        sb.append(-1).append(System.lineSeparator());
                        break;
                    }
                    sb.append(stack.peek()).append(System.lineSeparator());
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);

    }
}
