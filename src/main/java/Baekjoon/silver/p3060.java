package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p3060 {

    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] pigs = new long[6];

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int remainMeals = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 6; j++){
                pigs[j] = Integer.parseInt(st.nextToken());
            }

            sumPigMeal(pigs, remainMeals);

            al.add(count);
            count = 1;
        }
        for(int out : al) {
            System.out.println(out);
        }
    }
    /*      2
            21
            1 2 3 4 5 6
            21
            1 2 3 4 5 7*/
    static int sumPigMeal(long[] pigs, int meals) {
        long eatted = 0;
        for(long eat : pigs){ // 돼지가 먹은 초기값
            eatted += eat;
        }
        long[] temp = new long[6];
        while(meals >= eatted){
            for(int i = 0; i < 6; i++) {// 자기자신 + -1 + +1 + 맞은편
                temp[i] = pigs[i] + pigs[(i+5)%6] + pigs[(i+1)%6] + pigs[(i+3)%6]; // 양옆맞은편 더하기
            }
            pigs = temp.clone();
            eatted = 0;
            for(long each : pigs){
                eatted += each;
            }
            count++;
        }
        return count;
    }

}
