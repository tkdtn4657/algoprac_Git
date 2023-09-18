package Programmers.lv0;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class p181914 {
    public static void main(String[] args) {

        System.out.println(new Solution().solution2("78720646226947352489"));

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

    public int solution2(String number) {
        //mapToInt는 10만의 제한때문에 할 수 없음
//        return IntStream.range(0, number.toCharArray().length)
//                .mapToObj(i -> Character.getNumericValue(number.charAt(i)))
//                .reduce(0, Integer::sum) % 9;


//        number.chars()
//                .map(Character::getNumericValue)
//                .reduce(0, Integer::sum);
//        return sum % 9;

//        return number.chars()
//                .map(ch -> Character.getNumericValue(ch))
//                .reduce(0, (x, y) -> x + y) % 9;



        return number.chars()
                .map(Character::getNumericValue)
                .reduce(0,(x, y) -> x + y) % 9;

    }
}
