package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] inputs = new int[n];
        for(int i = 0; i < n; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, inputs[i]);
        }

        int start = inputs[0];
        int[] parents = new int[max+1];
        Arrays.fill(parents, -2);

        StringBuilder sb = new StringBuilder()
                .append(parents.length)
                .append(System.lineSeparator());

        parents[start] = -1;
        for(int i = 1; i < inputs.length; i++){
            if(parents[inputs[i]] == -2) parents[inputs[i]] = inputs[i-1];
        }

        for(int number : parents){
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }
}
