package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p15728 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] shareCard = new Integer[n];
        Integer[] teamCard = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            shareCard[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            teamCard[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> hs = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int multiply = shareCard[i] *teamCard[j];
                al.add(multiply);
                if(hs.putIfAbsent(teamCard[j], multiply) != null){
                    hs.put(teamCard[j], Integer.max(hs.get(teamCard[j]), multiply));
                }
            }
        }

        List<Integer> valueList = new ArrayList<>(hs.values());
        valueList.sort((o1, o2) -> o2 - o1);

        System.out.println(valueList.get(k));
    }
}
