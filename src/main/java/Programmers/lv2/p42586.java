package Programmers.lv2;

import java.io.*;
import java.util.*;
public class p42586 {
    public static void main(String[] args) {

        for(int num : solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})){
            System.out.println(num);
        }


    }

    /**
     *
     * 각 배열의 값을 클래스에 저장?
     * 그냥 배열에 저장해도 상관없나?
     * day라는 가중치로 이후에 있는 저장요소가 완료되었는지 판단하기
     *
     */
    static int[] solution(int[] progresses, int[] speeds){

        int day = 1;
        int[] dayCount = new int[100];

        for(int i = 0; i < progresses.length; i++){
            while(progresses[i] + speeds[i]*day < 100){
                day++;
            }
            dayCount[day]++;
        }

        return Arrays.stream(dayCount)
                .filter((n) -> n > 0).toArray();
    }
}
