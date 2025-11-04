package Programmers.lv1;

import java.util.*;

public class p12944 {
    public static void main(String[] args) {

    }

    class Solution {
        public double solution(int[] arr) {
            return Arrays.stream(arr).average().getAsDouble();
        }
    }
}
