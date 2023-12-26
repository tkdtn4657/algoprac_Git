package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p5618 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(al);

        int minNum = al.get(0);
        for(int i = 1; i <= minNum; i++){
            int count = 0;
            if(minNum % i == 0){
                count++;
                for(int j = 1; j < n; j++){
                    if(al.get(j) % i == 0){
                        count++;
                    }
                }
            }
            if(count == n){
                System.out.println(i);
            }
        }
    }
}
