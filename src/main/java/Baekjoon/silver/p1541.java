package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        //split을 기준으로 자르기
        Queue<Character> sign = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign.add(s.charAt(i));
            }
        }
        //기호를 다 넣어줬으면, 번호를 잘라넣음
        StringTokenizer st = new StringTokenizer(s, "\\+|\\-");
        while (st.hasMoreTokens()) {
            num.add(Integer.valueOf(st.nextToken()));
        }

        calc(sign, num);
    }

    static void calc(Queue<Character> sign, Queue<Integer> num) {
        int result = 0;
        boolean firstVisit = true;
        boolean minusStart = false;
        while (!num.isEmpty()) {
            if (!firstVisit && minusStart) {
                result -= num.poll();
            } else {
                if(!firstVisit && '-' == sign.poll()){
                    minusStart = true;
                    result -= num.poll();
                    continue;
                }
                result += num.poll();
                firstVisit = false;

            }
        }
        System.out.println(result);
    }
}

//public class p1541 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
//        int start = 0;
//        int end = 0;
//
//        int result = 0;
//        int minusSum = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == '-'){
//                start = i;
//                i++;
//                while(i < s.length()){
//                    if(s.charAt(i) =='-' || i == s.length()){
//                        end = i;
//                        String temp = s.substring(start, end);
//                        s = s.replaceFirst(Pattern.quote(temp), "");
//                        temp = temp.replace("-", "");
//                        for(String stringToInt : temp.split("\\+")){
//                            minusSum += Integer.valueOf(stringToInt);
//                        }
//                        i = 0;
//                        break;
//                    }
//                    i++;
//                }
//            }
//        }
//        if(start != 0 && end == 0){
//            String temp = s.substring(start, s.length());
//            s = s.replace(temp, "");
//            temp = temp.replaceFirst("\\-", "");
//            for(String stringToInt : temp.split("\\+")){
//                minusSum += Integer.valueOf(stringToInt);
//            }
//        }
//        for(String stringToInt : s.split("\\+")){
//            result += Integer.valueOf(stringToInt);
//        }
//
//        result -= minusSum;
//        System.out.println(result);
//    }
//}
