package Programmers.lv1;

import java.util.ArrayList;

public class p120888 {
    //Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));
    //중복되지 않는 set의 특성을 활용 참고하셈
    // 난 구현못함 ㅋㅋ;
    public String solution(String my_string) {
        String answer = "";

        ArrayList<Character> a = new ArrayList<>();
        char c = ' ';

        for (int i = 0; i < my_string.length(); i++) {
            if (checkInsertChar(my_string.charAt(i), a)) {
                a.add(my_string.charAt(i));
            }
        }

        char[] cString = new char[a.size()];

        for(int i = 0; i < a.size(); i++){
            cString[i] = a.get(i);
        }

        return new String(cString);
    }
    boolean checkInsertChar(char checkChar,ArrayList<Character> a){
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) == checkChar){
                return false;
            }
        }
        return true;
    }
}
