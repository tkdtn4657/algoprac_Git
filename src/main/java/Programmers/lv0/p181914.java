package Programmers.lv0;

import java.util.function.Function;

public class p181914 {
    public static void main(String[] args) {

        System.out.println(new Solution().solution("13"));

    }
}

class Solution {
    public int solution(String number) {
        Function<String, Integer> counter = string -> {

        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            count += number.charAt(i) - '0';
        }

        return count % 9;
    };

        return counter.apply(number);
    }
}
