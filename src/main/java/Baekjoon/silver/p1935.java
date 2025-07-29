package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[26];

        String inputText = br.readLine();

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < inputText.length(); i++){
            char nowChar = inputText.charAt(i);
            if(nowChar >= 'A' && nowChar <= 'Z'){
                stack.push((double) a[nowChar - 'A']);
            } else {
                Double firstNum = stack.pop();
                Double secondNum = stack.pop();

                switch(nowChar){
                    case '+' :
                        stack.push(secondNum + firstNum);
                        break;
                    case '-' :
                        stack.push(secondNum - firstNum);
                        break;
                    case '*' :
                        stack.push(secondNum * firstNum);
                        break;
                    case '/' :
                        stack.push(secondNum / firstNum);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

    }
}
