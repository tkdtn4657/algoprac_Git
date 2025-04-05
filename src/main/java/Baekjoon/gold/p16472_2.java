package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16472_2 {
    public static void main(String[] args) throws IOException{

        /**
         * 문자열 인식을 어떻게 하는거지?
         * 좌측에 포인터를 두개 다 잡고 그냥 진행해나가면 시간초과인가?
         * 일단 해보죠
         * 정렬하는건 아니겠지..?
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] stringArray = br.readLine().toCharArray();
        Set<Character> set = new HashSet<>();

        //abbcaccba
        int i = 0;
        int j = 0;
        int charCount = 0;
        int max = Integer.MIN_VALUE;
        //hashset에 존재하지 않으면 추가하면 되고, 카운트 초과되면 i++로 넘어가고 그러면 10만 factorial인데 이래도 되나..?
        while(i <= stringArray.length-1){
            if(j >= stringArray.length){
                max = Integer.max(max, charCount);
                break;
            }

            char nowChar = stringArray[j];

            if(set.add(nowChar)){
                if(set.size() > n) {
                    i++;
                    j = i;
                    set.clear();
                    max = Integer.max(max, charCount);
                    charCount = 0;
                    continue;
                }
                j++;
                charCount++;
            } else {

                j++;
                charCount++;
            }
        }

        System.out.println(max);
    }
}
