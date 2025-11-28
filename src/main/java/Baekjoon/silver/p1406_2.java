package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        s.chars().forEach( c -> leftStack.push((char) c));

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            switch (command){
                case 'L':
                    if(leftStack.isEmpty()) break;
                    rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(rightStack.isEmpty()) break;
                    leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(leftStack.isEmpty()) break;
                    leftStack.pop();
                    break;
                case 'P':
                    char nextChar = st.nextToken().charAt(0);
                    leftStack.push(nextChar);
                    break;
            }

        }

        StringBuilder sb = new StringBuilder();
        leftStack.forEach(sb::append);
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);

    }
}
