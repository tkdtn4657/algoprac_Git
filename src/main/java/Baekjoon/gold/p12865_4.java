package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12865_4 {

    static int n;
    static int k;
    static int maxValue = 0;
    static List<OneThing> allThingList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //1. 브루트포스(시간초과)
//        for(int i = 0; i < n; i++){
//            st = new StringTokenizer(br.readLine());
//            int w = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            OneThing thing = new OneThing(w, v);
//            allThingList.add(thing);
//        }
//        recur(0, allThingList.size(), new ArrayList<>());
//        System.out.println(maxValue);
        //2. DP
        //무게 기준으로 직전 최대 값 (스킵)
        //무게 기준으로 현재 무게와 이전 무게 값을 더한 값 (선택) j-w
        int[][] dp = new int[n+1][k+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= k; j++){
                dp[i][j] = dp[i-1][j];
                if(j-w >= 0){
                    dp[i][j] = Integer.max(dp[i][j], dp[i-1][j-w] + v);
                }
            }
        }

        System.out.println(dp[n][k]);

    }

    //브루트포스(시간초과)
    private static void recur(int count, int size, List<OneThing> selectedList){
        if(count == size){
            maxValue = Integer.max(maxValue, OneThing.maxValue(selectedList));
            return;
        }

        recur(count + 1, size, new ArrayList<>(selectedList));
        OneThing thing = allThingList.get(count);
        selectedList.add(thing);
        if(OneThing.isAvailableAddThing(selectedList)){
            recur(count + 1, size, new ArrayList<>(selectedList));
        }

    }

    private static class OneThing {

        final int w;
        final int v;

        OneThing(int w, int v){
            this.w = w;
            this.v = v;
        }

        public static int maxValue(List<OneThing> thingList){
            return thingList.stream().mapToInt( n -> n.v).sum();
        }

        public static boolean isAvailableAddThing(List<OneThing> thingList){
            return thingList.stream().mapToInt( n -> n.w).sum() <= k;
        }
    }

}


