package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //괄호 : Parenthesis
        //스택으로 입력을 받고, 닫괄이 나올 때까지 쭉 스택에 넣어주기만 함,
        //닫괄이 나오면 스택을 하나씩 pop해주고
        //닫괄이 입력되었지만 스택이 비어있으면 NO 그게 아니면 YES
        //스택 안써도 구현 가능하니까 스택 쓰지말고 해볼까?

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            String s = br.readLine();

            int leftParenthesisCount = 0;
            boolean isVPS = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (leftParenthesisCount <= 0){
                        isVPS = false;
                        break;
                    } else {
                        leftParenthesisCount--;
                    }
                } else {
                    leftParenthesisCount++;
                }
            }

            if(!isVPS || leftParenthesisCount > 0){
                sb.append("NO").append(System.lineSeparator());
            } else {
                sb.append("YES").append(System.lineSeparator());
            }
        }

        System.out.println(sb);

    }
}
