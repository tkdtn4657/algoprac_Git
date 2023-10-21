package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){

            String s = br.readLine();
            stack = new Stack<>();
            boolean flag = true;

            for(int j = 0; j < s.length(); j++){
                switch (s.charAt(j)){
                    case '(' -> stack.push('(');

                    case')' -> {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if(!stack.isEmpty() || !flag){
                sb.append("NO").append("\n");
            } else{
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}
