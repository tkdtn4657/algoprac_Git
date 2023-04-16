package Programmers.lv1;

import java.util.Arrays;

public class p120911 {
    public String solution(String my_string) {
        String answer = "";
        char[] cString = new char[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) < 97) { // 대문자의 경우
                //변환하세요.
                cString[i] = (char) (my_string.charAt(i) + 32);
            } else {
                cString[i] = my_string.charAt(i);
            }
        }

        Arrays.sort(cString);

        return new String(cString);
    }
}

/* 참고하면 좋은 코드
* class Solution {
    public String solution(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
* */