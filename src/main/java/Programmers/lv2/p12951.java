package Programmers.lv2;

public class p12951 {
    public static void main(String[] args) {
        String s = "for the last week";
        System.out.println(solution(s));
    }

    static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char nowChar = s.charAt(i);
            if (nowChar == ' ') {
                count = 0;
                sb.append(" ");
            } else if (count == 1) {
                sb.append(changeChar(nowChar, 1));
            } else {
                sb.append(changeChar(nowChar, 2));
            }
            count++;
        }
        return sb.toString();
    }

    //1 : 대문자 | 2 : 소문자
    static char changeChar(char c, int mode) {
        if (mode == 1) {
            if (c >= 'a' && c <= 'z') {
                return String.valueOf(c).toUpperCase().charAt(0);
            } else {
                return c;
            }
        } else {
            if (c >= 'A' && c <= 'Z') {
                return String.valueOf(c).toLowerCase().charAt(0);
            } else {
                return c;
            }
        }
    }
}
