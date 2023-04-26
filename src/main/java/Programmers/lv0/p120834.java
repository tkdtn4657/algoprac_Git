package Programmers.lv0;

public class p120834 {
    public String solution(int age) {
        String answer = new String(Integer.toString(age));
        char[] c = new char[answer.length()];
        char[] atoj = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        for(int i = 0; i < answer.length(); i++){
            c[i] = atoj[Integer.parseInt(String.valueOf(answer.charAt(i)))];

        }
        return new String(c);
    }
}
