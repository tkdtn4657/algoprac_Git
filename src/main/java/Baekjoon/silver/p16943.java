package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16943 {
    static int a;
    static int b;
    static int aLength = 0;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        String aString = String.valueOf(a);
        aLength = aString.length();
        visited = new boolean[aLength];

        int[] listArray = new int[aLength];

        List<Integer> list = new ArrayList<>();
        int setAddNum = a;
        for(int i = 0; i < aLength; i++){
            if(setAddNum > 0) {
                list.add(setAddNum % 10);
                listArray[i] = setAddNum % 10;
                setAddNum /= 10;
            } else {
                list.add(setAddNum);
                listArray[i] = setAddNum;
            }
        }

        //10억보다 작은 순열?
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 0) continue;
            recur(new StringBuilder(list.get(i)), listArray, 0);
        }

        if(max == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }


    }

    private static void recur(StringBuilder num, int[] list, int count){
        if(count == aLength){
            int numToInteger = Integer.parseInt(num.toString());
            if(numToInteger < b) {
                max = Integer.max(max, numToInteger);
            }
            return;
        }

        for(int i = 0; i < list.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                num.append(list[i]);
                if(Integer.parseInt(num.toString()) != 0) {
                    recur(num, list, count + 1);
                }
                num.setLength(num.length() - 1);

                visited[i] = false;
            }
        }
    }
}
