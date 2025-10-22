package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11047_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while(!stack.isEmpty()){
            Integer num = stack.pop();
            if(k / num > 0){
                count += k/num;
                k %= num;
            }
            if(k == 0) break;
        }
        System.out.println(count);
    }
}
