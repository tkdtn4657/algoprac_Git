package Programmers.lv0;

import java.util.ArrayList;

public class p120905 {
    public int[] solution(int n, int[] numlist) {

        ArrayList<Integer> a = new ArrayList<>();

        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                a.add(numlist[i]);
            }
        }
        int[] answer = new int[a.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = a.get(i);
        }
        return answer;
    }
}
