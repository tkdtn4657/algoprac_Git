package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16472{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] s = br.readLine().toCharArray();
        int[] check = new int[26];

        int start = 0;
        int end = 0;
        int count = 0;
        int result = n;

        if(n > s.length){
            System.out.println(s.length);
            return;
        }

        while(end < s.length){
            if(check[s[end]-'a'] == 0 && count < n) {
                check[s[end]-'a']++;
                end++;
                count++;
            }else if(count == n){
                if(check[s[end]-'a'] != 0){
                    end++;
                }else{
                    result = Math.max(result, end-start);
                    check[s[start]-'a']--;
                    start++;
                    end = start;
                    count--;
                }
            }else{
                if(check[s[end]-'a'] != 0){
                    end++;
                }
            }
            if(end == s.length){
                result = Math.max(result, s.length-start);
            }
        }
        System.out.println(result);
    }
}




//public class p16472 { //시간초과코드
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        char[] s = br.readLine().toCharArray();
//        Set<Character> cs = new HashSet<>();
//        int result = n;
//
//        if (s.length < n) {
//            System.out.println(s.length);
//            return;
//        }
//
//        int index;
//
//        //카운트만 없애보자
//        for (int i = 0; i < s.length - n; i++) {
//            index = i;
//            while (cs.size() <= n && index < s.length) {
//                cs.add(s[index]);
//
//                if (cs.size() > n) {
//                    result = Integer.max(result, index-i);
//                    cs.clear();
//                    break;
//                }else{
//                    index++;
//                    if(index==s.length){
//                        result =Integer.max(result, index-i);
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//    }
//}