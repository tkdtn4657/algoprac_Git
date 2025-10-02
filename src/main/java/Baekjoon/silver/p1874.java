package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 ~ n 까지 수가 진행되고, 스택으로 입력된 수열을 만들 수 있는지 검증?
        //Queue에 1 ~ n 까지의 값을 넣어두기
        //스택에 해당 값을 넣어가며 시뮬?
        //안되는 케이스를 어떻게 구분해야할까?

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int current = 1;

        boolean possible = true;
        for(int num : sequence){
            while (current <= num) {
                stack.push(current++);
                sb.append("+").append(System.lineSeparator());
            }

            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-").append(System.lineSeparator());
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }

    }
}
