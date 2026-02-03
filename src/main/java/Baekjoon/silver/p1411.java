package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1411 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //27개 중에서 어떻게 바꾸는지..

        List<String> words = new ArrayList<>();

        for(int i = 0; i < n; i++){
            words.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            String nowWord = words.get(i);
            for(int j = i+1; j < n; j++){
                Map<Character, Character> map = new HashMap<>();
                String checkWord = words.get(j);
                for(int wordIndex = 0; wordIndex < nowWord.length(); wordIndex++){
                    if(map.containsKey(nowWord.charAt(wordIndex))){
                        if(map.get(nowWord.charAt(wordIndex)) != checkWord.charAt(wordIndex)){
                            map.clear();
                            break;
                        }
                    } else {
                        if(!map.containsValue(checkWord.charAt(wordIndex))) {
                            map.put(nowWord.charAt(wordIndex), checkWord.charAt(wordIndex));
                        } else {
                            break;
                        }
                    }

                    if(wordIndex == nowWord.length()-1){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


    }


}
