package Programmers.lv1;

public class p120891 {
    public int solution(int order) {
        // 참고 String str = order+"";이렇게 문자열로 바꿀 수도 있음

        int answer = 0;
        String s = Integer.toString(order);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '3' | s.charAt(i) == '6' | s.charAt(i) == '9') {
                answer++;
            }
        }

        return answer;
    }
}
