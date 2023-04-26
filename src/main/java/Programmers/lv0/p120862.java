package Programmers.lv0;

import java.util.ArrayList;

public class p120862 {

    public int solution(int[] numbers) {
        int n = numbers.length;
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                a.add(numbers[i] * numbers[j]); // 모든 경우의 수 입력
            }
        }


        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        return maxCompare(a);
    }


    //첫번째 시도 실패 - max를 0으로 했기에 -값만 있을 때 제대로 검증을 못했음
    int maxCompare(ArrayList<Integer> a) {
        int max = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > max) {
                max = a.get(i);
            }
        }
        return max;
    }
}
