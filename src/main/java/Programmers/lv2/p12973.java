package Programmers.lv2;

import java.util.*;

public class p12973 {
    public static void main(String[] args) {
        String s = "cdcd";
        System.out.println(solution(s));

    }

    static int solution(String s)
    {
        Stack<Character> characterStack = new Stack<>();
        characterStack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);

            if(!characterStack.isEmpty()) {
                if (characterStack.peek() != c) {
                    characterStack.push(c);
                } else {
                    characterStack.pop();
                }
            }else if(characterStack.isEmpty()){
                characterStack.push(c);
            }
        }
        if(characterStack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

//    static int solution(String s){
//        for(int i = s.length()-1; i >= 1; i--){
//            char prevChar = s.charAt(i-1);
//            char thisChar = s.charAt(i);
//            if(prevChar == thisChar) {
//                s = s.replaceAll(String.valueOf(thisChar) + String.valueOf(thisChar), "");
//                i = s.length();
//            }
//        }
//        if(s.length() == 0){
//            return 1;
//        }else{
//            return 0;
//        }
//
//    }
}
