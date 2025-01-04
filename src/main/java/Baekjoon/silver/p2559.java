package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2559 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Long> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            al.add(Long.parseLong(st.nextToken()));
        }

        ArrayList<Long> prefixSum = new ArrayList<>();

        prefixSum.add(al.get(0));
        for(int i = 1; i < al.size(); i++){
            prefixSum.add(al.get(i)+prefixSum.get(i-1));
        }

        long max = prefixSum.get(k-1);
        for(int i = k; i < n; i++){
            max = Long.max(max, prefixSum.get(i) - prefixSum.get(i-k));
        }
        System.out.println(max);
    }
}
