package Programmers.lv0;

import java.util.stream.IntStream;
import java.util.Arrays;

public class p120817 {
    public double solution(int[] numbers) {
        IntStream intStream = Arrays.stream(numbers);

        return (double)intStream.average().orElseThrow();
    }
}
