package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Long> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            al.add(Long.parseLong(st.nextToken()));
        }

        ArrayList<Long> prefixSum = new ArrayList<>();

        prefixSum.add(al.get(0));
        for(int i = 1; i < al.size(); i++){
            prefixSum.add(Long.max(prefixSum.get(i-1)+ al.get(i), al.get(i)));
        }

        long max = prefixSum.get(0);
        for(int i = 1; i < prefixSum.size(); i++){
            max = Math.max(max, prefixSum.get(i));
        }
        System.out.println(max);

    }
}
