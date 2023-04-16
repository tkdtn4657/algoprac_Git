package Programmers.lv1;

import java.util.ArrayList;

public class p120897 {
    public int[] solution(int n) {
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                a.add(i);
            }
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }

        return answer;
    }
}
