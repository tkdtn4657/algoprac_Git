package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11507 {
    static int[] cardIndexCount = new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //갖고 있는 카드셋을 배열에 넣으면됨
        String s = br.readLine();

        String[] cards = threeLengthSplit(s);

        int dupleCheckSize = Arrays.stream(cards).distinct().toArray().length;

        if(cards.length != dupleCheckSize){
            System.out.println("GRESKA");
            return;
        }

        //P 스페이드 | K 클로버 | H 하트 | T 다이아몬드
        for(String card : cards){
            switch (card.charAt(0)){
                case 'P' -> {
                    cardIndexCount[0]++;
                }

                case 'K' -> {
                    cardIndexCount[1]++;
                }

                case 'H' -> {
                    cardIndexCount[2]++;
                }

                case 'T' -> {
                    cardIndexCount[3]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num : cardIndexCount){
            sb.append(13-num).append(" ");
        }

        System.out.println(sb);

    }

    public static String[] threeLengthSplit(String s){
        String[] a = new String[s.length()/3];
        int index = 0;
        for(int i = 0; i < s.length(); i+=3, index++){
            a[index] = s.substring(i, i+3);
        }

        return a;
    }
}