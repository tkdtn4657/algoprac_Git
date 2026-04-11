package Programmers.lv2;

import java.util.*;

public class p42860 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("ABBAAB"));
    }

    static class Solution {
        //A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

        public int solution(String name) {
            int answer = 0;
            int n = name.length();

            // 1. 세로 이동
            for (int i = 0; i < n; i++) {
                char c = name.charAt(i);
                int up = c - 'A';
                int down = 'Z' - c + 1;
                answer += Math.min(up, down);
            }

            // 2. 가로 이동(커서 이동 비용)
            int minMove = n - 1; // 일단 끝까지 오른쪽으로만 가는 경우

            for (int i = 0; i < n; i++) {
                int endOfA = i + 1;

                // i 다음부터 연속된 A 구간 찾기
                while (endOfA < n && name.charAt(endOfA) == 'A') {
                    endOfA++;
                }

                // 방법 1: 오른쪽으로 i까지 갔다가 다시 돌아오기
                int moveRightThenLeft = i * 2 + (n - endOfA);

                // 방법 2: 끝쪽 먼저 처리하고 다시 돌아오기
                int moveLeftThenRight = i + (n - endOfA) * 2;

                minMove = Math.min(minMove, moveRightThenLeft);
                minMove = Math.min(minMove, moveLeftThenRight);

            }

            return answer + minMove;
        }

    }
}
