package Programmers.lv1;

import java.util.HashMap;

public class p120838 {
    
    //String +로 붙이는거 매번 까먹어서 리마인드차 올렸음ㅇㅇㅇㅇ
//    for(String str : letters){
//        answer += morse.get(str);
//    }
    public String solution(String letter) {
        HashMap<String, Character> morse = new HashMap<String, Character>();

        morse.put(".-", 'a'); morse.put("-...", 'b'); morse.put("-.-.", 'c');morse.put("-..", 'd');
        morse.put(".", 'e');morse.put("..-.", 'f');morse.put("--.", 'g');morse.put("....", 'h');morse.put("..", 'i');
        morse.put(".---", 'j');morse.put("-.-", 'k');morse.put(".-..", 'l');morse.put("--", 'm');
        morse.put("-.", 'n');morse.put("---", 'o');morse.put(".--.", 'p');morse.put("--.-", 'q');morse.put(".-.", 'r');
        morse.put("...", 's');morse.put("-", 't');morse.put("..-", 'u');morse.put("...-", 'v');
        morse.put(".--", 'w');morse.put("-..-", 'x');morse.put("-.--", 'y');morse.put("--..", 'z');

        String[] s = letter.split(" ");

        char[] cString = new char[s.length];


        for(int i = 0; i < s.length; i++) {
            cString[i] = morse.get(s[i]);
        }

        return new String(cString);
    }
}
//        '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
//        '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
//        '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
//        '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
//        '-.--':'y','--..':'z'